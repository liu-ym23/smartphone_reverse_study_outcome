package com.larus.bot.impl.feature.botmaker;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.bean.BotGenBgImageResponse;
import com.larus.bot.impl.bean.GenBotImageRequest;
import com.larus.bot.impl.common.util.BitmapHelperKt;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.message.Message;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.y;
import com.larus.platform.model.bot.BotMakerDataModel;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.o0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public static final k a = null;
    public static final Gson b = null;
    public static final UgcBotRepo c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Map<String, Job> f = null;
    public static final Map<String, Job> g = null;
    public static final Map<String, String> h = null;
    public static final Map<String, String> i = null;
    public static final Map<String, BgImage> j = null;
    public static final Map<String, String> k = null;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bot/impl/feature/botmaker/BotMakerModel$getBotMakerDataFromJson$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/platform/model/bot/BotMakerDataModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<BotMakerDataModel> {
        public a() {
        }
    }

    public k() {
    }

    static {
        a = new k();
        b = new Gson();
        Lazy<UgcBotRepo> r0 = UgcBotRepo.d;
        c = UgcBotRepo.a.a();
        d = LazyKt.lazy(new g());
        e = LazyKt.lazy(new h());
        f = new LinkedHashMap();
        g = new LinkedHashMap();
        h = new LinkedHashMap();
        i = new LinkedHashMap();
        j = new LinkedHashMap();
        k = new LinkedHashMap();
    }

    public static BotLanguage e() {
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L12;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L12;
        List r2 = r1.j();
        if (r2 == null) goto L12;
        List r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        com.larus.im.bean.bot.BotLanguage r6 = (com.larus.im.bean.bot.BotLanguage) r5.next();
        r4.add(new BotLanguage(r6.getLanguageCode(), r6.getLanguage(), r6.getLanguageLocal()));
    L14:
        if (AppHost.a.isOversea() == false) goto L39;
        if (r4 == null) goto L25;
        Iterator r7 = r4.iterator();
    L18:
        if (r7.hasNext() == false) goto L22;
        Object r8 = r7.next();
        String r9 = ((BotLanguage) r8).c();
        AppLocaleUtils.a.getClass();
        if (Intrinsics.areEqual(r9, AppLocaleUtils.c().getLanguage()) == false) goto L18;
    L23:
        BotLanguage r10 = (BotLanguage) r8;
        if (r10 == null) goto L25;
    L64:
        return r10;
    L22:
        r8 = null;
    L25:
        if (r4 == null) goto L34;
        Iterator r11 = r4.iterator();
    L28:
        if (r11.hasNext() == false) goto L32;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((BotLanguage) r12).c(), "en") == false) goto L28;
    L33:
        r10 = (BotLanguage) r12;
    L35:
        if (r10 != null) goto L64;
        if (r4 != null) goto L63;
        return null;
    L63:
        return (BotLanguage) ListProtector.get(r4, 0);
    L32:
        r12 = null;
        goto L33
    L34:
        r10 = null;
        goto L35
    L39:
        if (r4 == null) goto L49;
        Iterator r13 = r4.iterator();
    L42:
        if (r13.hasNext() == false) goto L46;
        Object r14 = r13.next();
        if (Intrinsics.areEqual(((BotLanguage) r14).c(), "zh") == false) goto L42;
    L47:
        r10 = (BotLanguage) r14;
        if (r10 != null) goto L64;
    L46:
        r14 = null;
    L49:
        if (r4 != null) goto L51;
        return null;
    L51:
        return (BotLanguage) ListProtector.get(r4, 0);
    L12:
        r4 = null;
        goto L14
    }

    public static void b(Message r18) {
        Intrinsics.checkNotNullParameter(r18, "message");
        final String r0 = r18.getMessageId();
        String r3 = r18.getConversationId();
        long r4 = r18.getServerIndex();
        String r1 = r18.getContent();
        boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L32;
        Map<String, Job> r9 = f;
        if (r9.containsKey(r0) == false) goto L14;
        Job r5 = (Job) ((LinkedHashMap) r9).get(r0);
        return;
    L14:
        if (r3 != null) goto L16;
    L17:
        r2 = true;
    L18:
        if (r2 == false) goto L20;
        return;
    L20:
        if (r4 == (-1)) goto L33;
        IChatRepoService r6 = RepoDispatcherDelegate.b.e();
        BotMakerDataModel r10 = d(r1);
        if (r10 == null) goto L31;
        BotMakerDataModel r8 = BotMakerDataModel.copy$default(r10, null, null, null, null, null, 31, null);
        if (r8 == null) goto L34;
        Job r11 = BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BotMakerModel$generateImageUrl$job$1(r6, r3, r4, r8, r0, null), 3, null);
        r11.invokeOnCompletion(new i(r0));
        r9.put(r0, r11);
        return;
    L34:
        return;
    L31:
        return;
    L33:
        return;
    L16:
        if (r3.length() != 0) goto L18;
    L32:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r7 = false;
        goto L9
    }

    public static BotMakerDataModel d(String r2) {
        return (BotMakerDataModel) b.fromJson(r2, new a().getType());
    L4:
        return null;
    }

    public static void c(final String r12, String r13) {
        boolean r0 = true;
        if (r13 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L35;
        if (r12 != null) goto L12;
    L15:
        if (r0 == true) goto L36;
        Map<String, Job> r1 = g;
        if (r1.containsKey(r12) == true) goto L37;
        LinkedHashMap r3 = (LinkedHashMap) k;
        if (o0.d((String) r3.get(r12)) == false) goto L23;
        String r14 = (String) r3.get(r12);
        return;
    L23:
        BotLanguage r4 = e();
        if (r4 == null) goto L29;
        String r5 = r4.c();
        if (r5 == null) goto L29;
        String r6 = r5;
    L30:
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = "";
        Job r15 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new BotMakerModel$generateVoice$job$1(r13, r6, r7, r12, null), 2, null);
        if (r15 == null) goto L33;
        r15.invokeOnCompletion(new j(r12));
    L33:
        r1.put(r12, r15);
        String r16 = (String) r7.element;
        return;
    L29:
        r6 = "";
        goto L30
    L37:
        return;
    L36:
        return;
    L12:
        if (r12.length() == 0) goto L15;
        r0 = false;
        goto L15
    L35:
        return;
    L5:
        if (r13.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static final Object a(k r29, String r30, String r31, Continuation r32) {
        r29.getClass();
        if ((r32 instanceof BotMakerModel$requestBotBgImage$1) == false) goto L7;
        BotMakerModel$requestBotBgImage$1 r1 = (BotMakerModel$requestBotBgImage$1) r32;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L25;
        if (r3 == 1) goto L24;
        if (r3 == 2) goto L23;
        if (r3 == 3) goto L21;
        if (r3 != 4) goto L20;
        BotAvatarIconData r4 = (BotAvatarIconData) r1.L$1;
        com.larus.network.http.a r5 = (com.larus.network.http.a) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L17
    L67:
        Object r6 = Result.constructor-impl((ImageUploadResult) ((com.larus.network.http.a) r0).b);     // Catch: Throwable -> L17
    L73:
        if (Result.isFailure-impl(r6) == false) goto L75;
        r6 = null;
    L75:
        ImageUploadResult r7 = (ImageUploadResult) r6;
    L79:
        if (r7 == null) goto L81;
        String r8 = r7.getUploadUrl();
    L83:
        if (o0.d(r8) == false) goto L97;
        if (r7 == null) goto L86;
        String r9 = r7.getUploadUri();
    L88:
        if (o0.d(r9) == false) goto L97;
        if (r7 == null) goto L92;
        String r16 = r7.getUploadUri();
    L93:
        if (r7 == null) goto L95;
        String r17 = r7.getUploadUrl();
    L96:
        BotAvatarIconData r11 = new BotAvatarIconData(r16, r17, null, null, null, 28, null);
    L99:
        if (r4 == null) goto L101;
        String r12 = r4.getIconUri();
    L102:
        if (r4 == null) goto L104;
        String r13 = r4.getIconUrl();
    L105:
        BotGenBgImageResponse r14 = (BotGenBgImageResponse) r5.b;
        if (r14 == null) goto L108;
        String r18 = r14.getBgImgPrompt();
    L109:
        BotGenBgImageResponse r15 = (BotGenBgImageResponse) r5.b;
        if (r15 == null) goto L112;
        String r19 = r15.getBgImgPromptEn();
    L113:
        BotGenBgImageResponse r20 = (BotGenBgImageResponse) r5.b;
        if (r20 == null) goto L116;
        Boolean r21 = r20.getBgImgOpen();
    L125:
        return new y(new wu8.d(r11, new BgImage(r12, r13, null, new BgImageInfo(r18, r19, Boxing.boxBoolean(true), null, r21, null, null, null, null, null, null, 2024, null))), null, 14);
    L116:
        r21 = null;
        goto L125
    L112:
        r19 = null;
        goto L113
    L108:
        r18 = null;
        goto L109
    L104:
        r13 = null;
        goto L105
    L101:
        r12 = null;
        goto L102
    L95:
        r17 = null;
        goto L96
    L92:
        r16 = null;
        goto L93
    L86:
        r9 = null;
    L97:
        r11 = r4;
        goto L99
    L81:
        r8 = null;
    L17:
        th = th;
        com.larus.network.http.a r110 = r5;
        BotAvatarIconData r111 = r4;
    L71:
        Result.Companion r22 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        r4 = r111;
        r5 = r110;
        goto L73
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r4 = (BotAvatarIconData) r1.L$1;
        com.larus.network.http.a r23 = (com.larus.network.http.a) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L22:
        r111 = r4;
        r110 = r23;
        File r24 = (File) r0;
        if (r24 != null) goto L122;
        r4 = r111;
        r23 = r110;
    L77:
        r5 = r23;
        r7 = null;
        goto L79
    L122:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L70
        BotImageUploadViewModel r26 = (BotImageUploadViewModel) e.getValue();     // Catch: Throwable -> L70
        Uri r27 = Uri.fromFile(r24);     // Catch: Throwable -> L70
        r1.L$0 = r110;     // Catch: Throwable -> L70
        r1.L$1 = r111;     // Catch: Throwable -> L70
        r1.label = 4;     // Catch: Throwable -> L70
        r0 = BotImageUploadViewModel.syncUpload$default(r26, r27, 0, null, false, r1, 14, null);     // Catch: Throwable -> L70
        if (r0 == r10) goto L129;
        r4 = r111;
        r5 = r110;
        goto L67
    L129:
        return r10;
    L70:
        th = th;
        goto L71
    L23:
        r4 = (BotAvatarIconData) r1.L$1;
        r23 = (com.larus.network.http.a) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L55:
        Bitmap r28 = (Bitmap) r0;
    L57:
        if (r28 == null) goto L77;
        r1.L$0 = r23;
        r1.L$1 = r4;
        r1.label = 3;
        r0 = BitmapHelperKt.g(null, r28, BgSelectViewModel.AVATAR_BITMAP_CACHE_FILE_NAME, r1);
        if (r0 != r10) goto L22;
        return r10;
    L24:
        ResultKt.throwOnFailure(r0);
    L28:
        r23 = (com.larus.network.http.a) r0;
        if ((r23 instanceof com.larus.network.http.f) == true) goto L124;
        BotGenBgImageResponse r33 = (BotGenBgImageResponse) r23.b;
        if (r33 == null) goto L36;
        List<BotAvatarIconData> r34 = r33.getBgImgList();
        if (r34 == null) goto L36;
        r4 = (BotAvatarIconData) CollectionsKt.firstOrNull(r34);
    L37:
        if (r4 == null) goto L39;
        String r35 = r4.getIconUri();
    L41:
        if (o0.d(r35) == false) goto L118;
        if (r4 == null) goto L44;
        String r36 = r4.getIconUrl();
    L46:
        if (o0.d(r36) == false) goto L118;
        if (r4 == null) goto L77;
        String r37 = r4.getIconUrl();
        if (r37 == null) goto L77;
        String r38 = r4.getIconUri();
        if (r38 == null) goto L56;
        AIGenBgImageRepository r39 = (AIGenBgImageRepository) d.getValue();
        r1.L$0 = r23;
        r1.L$1 = r4;
        r1.label = 2;
        r0 = r39.a(r38, r37, new com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.a(), r1);
        if (r0 != r10) goto L55;
        return r10;
    L56:
        r28 = null;
        goto L57
    L44:
        r36 = null;
    L118:
        AsyncThrowable.Companion.getClass();
        return new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null);
    L39:
        r35 = null;
    L36:
        r4 = null;
        goto L37
    L124:
        return new com.larus.network.http.f(((com.larus.network.http.f) r23).d, null);
    L25:
        ResultKt.throwOnFailure(r0);
        AIGenBgImageRepository r40 = (AIGenBgImageRepository) d.getValue();
        GenBotImageRequest r41 = new GenBotImageRequest(r30, r31, null, null, null, null, null, null, null, Boxing.boxBoolean(false), 508, null);
        r1.label = 1;
        r0 = r40.b("", 1, r41, "bot_maker", null, r1);
        if (r0 != r10) goto L28;
        return r10;
    L7:
        r1 = new BotMakerModel$requestBotBgImage$1(r29, r32);
        goto L8
    }
}
