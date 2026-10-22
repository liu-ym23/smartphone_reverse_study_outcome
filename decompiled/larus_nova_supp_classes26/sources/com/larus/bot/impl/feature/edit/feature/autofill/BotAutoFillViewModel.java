package com.larus.bot.impl.feature.edit.feature.autofill;

import android.graphics.Bitmap;
import android.net.Uri;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.bean.BotEditParam;
import com.larus.bot.impl.bean.BotGenBgImageResponse;
import com.larus.bot.impl.bean.ContentSource;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.bean.EnrichBotData;
import com.larus.bot.impl.bean.OperateType;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.common.propertyconfig.Visibility;
import com.larus.bot.impl.common.util.BitmapHelperKt;
import com.larus.bot.impl.feature.edit.BotCreateViewModel$_autoFillModel$2$1;
import com.larus.bot.impl.feature.edit.DescPolishStatus;
import com.larus.bot.impl.feature.edit.feature.autofill.model.BotEnrichParam;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel;
import com.larus.bot.impl.feature.edit.feature.firstmet.k;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.CreationIdInfo;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.y;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BotAutoFillViewModel implements j, wu8.f, wu8.e {
    public static final /* synthetic */ int x = 0;
    public final /* synthetic */ wu8.e a;
    public final CoroutineScope b;
    public final StateFlowImpl c;
    public final b1 d;
    public final MutableSharedFlow<com.larus.bot.impl.feature.edit.feature.autofill.b> e;
    public final a1 f;
    public final wu8.b g;
    public final Map<String, List<String>> h;
    public wu8.d i;
    public BotEditParam j;
    public boolean k;
    public Job l;
    public Job m;
    public final UgcBotRepo n;
    public final Lazy o;
    public final Lazy p;
    public final AtomicBoolean q;
    public boolean r;
    public int s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContentType.values().length];
            r0[ContentType.NAME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[ContentType.DESC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[ContentType.PROLOGUE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[ContentType.BIO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[ContentType.SUGGEST.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[ContentType.VOICE_ID.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[ContentType.HEAD_IMG_PROMPT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[ContentType.BG_IMG_PROMPT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[ContentType.LANGUAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            a = r0;
        }
    }

    static {
    }

    @Override // wu8.e
    public final BotEditParam a() {
        return this.a.a();
    }

    @Override // wu8.e
    public final void b() {
        this.a.b();
    }

    @Override // wu8.e
    public final void f() {
        this.a.f();
    }

    @Override // wu8.e
    public final void g() {
        this.a.g();
    }

    @Override // wu8.e
    public final dv8.b getBotCreateTrace() {
        return this.a.getBotCreateTrace();
    }

    @Override // wu8.e
    public final int getScene() {
        return this.a.getScene();
    }

    @Override // wu8.e
    public final void h(boolean r2, DescPolishStatus r3) {
        Intrinsics.checkNotNullParameter(r3, "status");
        this.a.h(r2, r3);
    }

    @Override // wu8.e
    public final wu8.g j() {
        return this.a.j();
    }

    @Override // wu8.e
    public final boolean l() {
        return this.a.l();
    }

    @Override // wu8.e
    public final void m(List<? extends wu8.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "itemsData");
        this.a.m(r2);
    }

    @Override // wu8.e
    public final void n(boolean r2) {
        this.a.n(r2);
    }

    public final void I() {
        if (this.g.a() == false) goto L6;
    L20:
        boolean r1 = false;
    L21:
        if (r1 == false) goto L24;
        Visibility r0 = Visibility.VISIBLE;
    L28:
        if (this.g.a() == true) goto L30;
        TextRes.StringResId r2 = new TextRes.StringResId(2131901080);
    L34:
        J(r0, r2);
        return;
    L30:
        if (this.g.d == false) goto L32;
        r2 = new TextRes.StringResId(2131901080);
        goto L34
    L32:
        r2 = new TextRes.StringResId(2131901137);
        goto L34
    L24:
        if (E() == false) goto L26;
        r0 = Visibility.DISABLE;
        goto L28
    L26:
        r0 = Visibility.HIDDEN;
        goto L28
    L6:
        if (E() == false) goto L20;
        r1 = true;
        if (o0.d(a().getIconUri()) == false) goto L12;
        if (F() == false) goto L21;
    L12:
        if ((!StringsKt.isBlank(a().getName())) == false) goto L16;
        if (H() == false) goto L21;
    L16:
        if ((!StringsKt.isBlank(a().getDescription())) == false) goto L20;
        if (G() == true) goto L20;
        goto L20
    }

    @Override // wu8.f
    public final boolean e() {
        if (((c) this.d.getValue()).a.a == Visibility.VISIBLE) goto L5;
        return false;
    L5:
        if (StringsKt.isBlank(a().getIconUri()) == false) goto L7;
    L8:
        L(com.larus.bot.impl.feature.edit.feature.autofill.b.a.a);
        return true;
    L7:
        if (StringsKt.isBlank(a().getDescription()) == true) goto L8;
        return false;
    }

    @Override // wu8.f
    public final boolean q() {
        if (this.s <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean E() {
        if (getScene() == 0) goto L5;
    L7:
        return false;
    L5:
        if (z2.a.createBotAutoFillEnable() == false) goto L7;
        return true;
    }

    public final boolean F() {
        String r0 = a().getIconUri();
        wu8.d r1 = this.i;
        String r2 = null;
        if (r1 == null) goto L7;
        BotAvatarIconData r3 = r1.a;
        if (r3 == null) goto L7;
        String r4 = r3.getIconUri();
    L9:
        if (Intrinsics.areEqual(r0, r4) == true) goto L11;
    L25:
        return false;
    L11:
        if (l() == false) goto L22;
        BgImage r5 = a().getBgImage();
        if (r5 == null) goto L15;
        String r6 = r5.bgImgUri;
    L16:
        wu8.d r7 = this.i;
        if (r7 == null) goto L21;
        BgImage r8 = r7.b;
        if (r8 == null) goto L21;
        r2 = r8.bgImgUri;
    L21:
        boolean r9 = Intrinsics.areEqual(r6, r2);
    L23:
        if (r9 == false) goto L25;
        return true;
    L15:
        r6 = null;
        goto L16
    L22:
        r9 = true;
    L7:
        r4 = null;
        goto L9
    }

    public final boolean G() {
        String r0 = a().getDescription();
        Map<String, List<String>> r1 = this.h;
        HashMap r2 = (HashMap) r1;
        List r3 = (List) r2.get(ContentType.DESC.getValue());
        if (r3 == null) goto L5;
        String r4 = (String) CollectionsKt.firstOrNull(r3);
    L7:
        if (Intrinsics.areEqual(r0, r4) == true) goto L9;
    L11:
        return false;
    L9:
        if (this.r == true) goto L11;
        return true;
    L5:
        r4 = null;
        goto L7
    }

    public final boolean H() {
        String r0 = a().getName();
        Map<String, List<String>> r1 = this.h;
        HashMap r2 = (HashMap) r1;
        List r3 = (List) r2.get(ContentType.NAME.getValue());
        if (r3 == null) goto L5;
        String r4 = (String) CollectionsKt.firstOrNull(r3);
    L7:
        return Intrinsics.areEqual(r0, r4);
    L5:
        r4 = null;
        goto L7
    }

    @Override // wu8.f
    public final int d() {
        return this.s;
    }

    @Override // uu8.b
    public final d1<com.larus.bot.impl.feature.edit.feature.autofill.b> getUiEvent() {
        return this.f;
    }

    @Override // uu8.b
    public final i1<c> getUiState() {
        return this.d;
    }

    @Override // wu8.f
    public final Map<String, List<String>> i() {
        return this.h;
    }

    @Override // wu8.f
    public final boolean k() {
        return this.k;
    }

    @Override // wu8.f
    public final boolean o() {
        return this.w;
    }

    @Override // wu8.f
    public final boolean p() {
        return this.v;
    }

    @Override // wu8.f
    public final wu8.d r() {
        return this.i;
    }

    @Override // wu8.f
    public final wu8.b s() {
        return this.g;
    }

    public static String y(List r9) {
        if (r9.isEmpty() == false) goto L6;
        return "";
    L6:
        ArrayList r0 = new ArrayList();
        Iterator r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L19;
        switch(b.a[((ContentType) r10.next()).ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L8;
            case 8: goto L12;
            default: goto L8;
        };
    L12:
        int r1 = j0.a;
        r0.add(j0.d(2131901082));
        goto L8
    L13:
        int r2 = j0.a;
        r0.add(j0.d(2131900243));
        goto L8
    L14:
        int r3 = j0.a;
        r0.add(j0.d(2131901105));
        goto L8
    L15:
        int r4 = j0.a;
        r0.add(j0.d(2131901097));
        goto L8
    L16:
        int r5 = j0.a;
        r0.add(j0.d(2131901099));
        goto L8
    L17:
        int r6 = j0.a;
        r0.add(j0.d(2131901085));
        goto L8
    L18:
        int r7 = j0.a;
        r0.add(j0.d(2131901077));
        goto L8
    L19:
        String r11 = CollectionsKt.joinToString$default(r0, ", ", null, null, 0, null, null, 62, null);
        return AppHost.a.getApplication().getString(2131901063, new Object[]{r11});
    }

    public final void B(AsyncThrowable r11) {
        if (r11 == null) goto L6;
        BizResponse.Companion.getClass();
        if (ArraysKt.contains(BizResponse.access$getCODE_RISK_CONTROL$cp(), r11.getCode()) == false) goto L6;
        D(this, r11);
    L7:
        m(CollectionsKt.listOf(new wu8.c.a(new wu8.d(new BotAvatarIconData(this.j.getIconUri(), this.j.getIconUrl(), this.j.getAvatarPrompt(), null, null, 24, null), this.j.getBgImage()))));
        return;
    L6:
        String r0 = y(CollectionsKt.listOf(ContentType.BG_IMG_PROMPT));
        Intrinsics.checkNotNullParameter(r0, "<this>");
        L(new com.larus.bot.impl.feature.edit.feature.autofill.b.C0054b(new TextRes.PlainText(r0)));
        goto L7
    }

    public final void L(com.larus.bot.impl.feature.edit.feature.autofill.b r7) {
        BuildersKt.launch$default(this.b, null, null, new BotAutoFillViewModel$sendUIEvent$1(this, r7, null), 3, null);
    }

    @Override // uu8.b
    public final void dispatchUIAction(com.larus.bot.impl.feature.edit.feature.autofill.a r9) {
        com.larus.bot.impl.feature.edit.feature.autofill.a r10 = r9;
        Intrinsics.checkNotNullParameter(r10, "uiAction");
        if (Intrinsics.areEqual(r10, com.larus.bot.impl.feature.edit.feature.autofill.a.C0053a.a) == false) goto L6;
        BuildersKt.launch$default(this.b, Dispatchers.getMain().getImmediate(), null, new BotAutoFillViewModel$onClickAutoFillBtn$1(this, null), 2, null);
        return;
    L6:
        if ((r10 instanceof com.larus.bot.impl.feature.edit.feature.autofill.a.b) == false) goto L12;
        if (((com.larus.bot.impl.feature.edit.feature.autofill.a.b) r10).a == false) goto L10;
        BuildersKt.launch$default(this.b, Dispatchers.getMain().getImmediate(), null, new BotAutoFillViewModel$onClickAutoFillBtn$1(this, null), 2, null);
        return;
    L10:
        f();
        return;
    L12:
        if (Intrinsics.areEqual(r10, com.larus.bot.impl.feature.edit.feature.autofill.a.e.a) == false) goto L15;
        I();
        return;
    L15:
        if (Intrinsics.areEqual(r10, com.larus.bot.impl.feature.edit.feature.autofill.a.c.a) == false) goto L21;
        if (z2.a.x3().getDisableBotDescPolish() == true) goto L31;
        BuildersKt.launch$default(this.b, null, null, new BotAutoFillViewModel$requireBotPolishDesc$1(this, null), 3, null);
        return;
    L31:
        return;
    L21:
        if (Intrinsics.areEqual(r10, com.larus.bot.impl.feature.edit.feature.autofill.a.d.a) == false) goto L25;
        this.r = false;
        return;
    L25:
        throw new NoWhenBranchMatchedException();
    }

    public final BotEnrichParam z(int r19) {
        EnrichBotData[] r1 = new EnrichBotData[10];
        wu8.d r2 = this.i;
        if (r2 == null) goto L7;
        BotAvatarIconData r3 = r2.a;
        if (r3 == null) goto L7;
        String r4 = r3.getPrompt();
    L8:
        String r5 = "";
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        List r6 = CollectionsKt.listOf(r4);
        String r7 = a().getAvatarPrompt();
        boolean r8 = true;
        if (r7.length() != 0) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == false) goto L19;
        r7 = a().getAvatarPromptForEnrich();
        if (r7 != null) goto L19;
        r7 = "";
    L19:
        String r10 = A(r6, CollectionsKt.listOf(r7));
        String r12 = ContentType.HEAD_IMG_PROMPT.getValue();
        String r11 = a().getAvatarPrompt();
        if (r11.length() != 0) goto L22;
        boolean r13 = true;
    L23:
        if (r13 == false) goto L27;
        r11 = a().getAvatarPromptForEnrich();
        if (r11 != null) goto L27;
        r11 = "";
    L27:
        EnrichBotData r14 = new EnrichBotData(r10, null, r12, CollectionsKt.listOf(r11), null, 18, null);
        if (l() == true) goto L30;
        EnrichBotData r15 = null;
    L55:
        if (r15 == null) goto L57;
        String r16 = r15.contentSource;
    L58:
        ContentSource r17 = ContentSource.USER_INPUT;
        if (Intrinsics.areEqual(r16, r17.getValue()) == false) goto L70;
        List<String> r18 = r15.content;
        if (r18 != null) goto L63;
    L66:
        boolean r20 = true;
    L67:
        if (r20 == true) goto L70;
        r14 = r15;
        goto L70
    L63:
        if (r18.isEmpty() == true) goto L66;
        r20 = false;
    L70:
        r14.contentType = ContentType.BG_IMG_PROMPT.getValue();
        r1[0] = r14;
        Map<String, List<String>> r21 = this.h;
        ContentType r22 = ContentType.NAME;
        r1[1] = new EnrichBotData(A((List) ((HashMap) r21).get(r22.getValue()), CollectionsKt.listOf(a().getName())), null, r22.getValue(), CollectionsKt.listOf(a().getName()), null, 18, null);
        List r23 = CollectionsKt.listOf(a().getDescription());
        Map<String, List<String>> r24 = this.h;
        ContentType r25 = ContentType.DESC;
        List r26 = (List) ((HashMap) r24).get(r25.getValue());
        CharSequence r110 = (CharSequence) CollectionsKt.firstOrNull(r23);
        if (r110 != null) goto L73;
    L76:
        boolean r111 = true;
    L77:
        if (r111 == false) goto L80;
        String r27 = ContentSource.NOT_ENTERED.getValue();
    L93:
        r1[2] = new EnrichBotData(r27, null, r25.getValue(), CollectionsKt.listOf(a().getDescription()), null, 18, null);
        if (j().c() == false) goto L99;
        String r28 = a().getPrologue();
        if (r28 != null) goto L98;
        r28 = "";
    L98:
        List r112 = CollectionsKt.listOf(r28);
        Map<String, List<String>> r29 = this.h;
        ContentType r30 = ContentType.PROLOGUE;
        EnrichBotData r31 = new EnrichBotData(A((List) ((HashMap) r29).get(r30.getValue()), r112), null, r30.getValue(), r112, null, 18, null);
    L100:
        r1[3] = r31;
        if (j().b() == false) goto L106;
        String r32 = a().getBio();
        if (r32 != null) goto L105;
        r32 = "";
    L105:
        List r113 = CollectionsKt.listOf(r32);
        Map<String, List<String>> r33 = this.h;
        ContentType r34 = ContentType.BIO;
        EnrichBotData r35 = new EnrichBotData(A((List) ((HashMap) r33).get(r34.getValue()), r113), null, r34.getValue(), r113, null, 18, null);
    L107:
        r1[4] = r35;
        if (j().a() == false) goto L118;
        Map<String, List<String>> r36 = this.h;
        ContentType r37 = ContentType.SUGGEST;
        List r38 = (List) ((HashMap) r36).get(r37.getValue());
        Triple<String, String, String> r39 = a().getSuggests();
        if (r39 == null) goto L112;
        List<String> r40 = k.c(r39);
    L113:
        String r114 = A(r38, r40);
        String r115 = r37.getValue();
        Triple<String, String, String> r41 = a().getSuggests();
        if (r41 == null) goto L116;
        List<String> r116 = k.c(r41);
    L117:
        EnrichBotData r42 = new EnrichBotData(r114, null, r115, r116, null, 18, null);
    L119:
        r1[5] = r42;
        if (j().d() == false) goto L141;
        SpeakerVoice r43 = a().getVoice();
        if (r43 == null) goto L124;
        String r44 = r43.getId();
    L125:
        if (r44 != null) goto L128;
        r44 = "";
    L128:
        if (StringsKt.isBlank(r44) == false) goto L130;
    L139:
        r17 = ContentSource.NOT_ENTERED;
    L140:
        EnrichBotData r45 = new EnrichBotData(r17.getValue(), null, ContentType.VOICE_ID.getValue(), CollectionsKt.listOf(r44), null, 18, null);
    L142:
        r1[6] = r45;
        BotLanguage r46 = a().getLanguage();
        if (r46 == null) goto L145;
        String r47 = r46.c();
    L146:
        if (r47 == null) goto L149;
        r5 = r47;
    L149:
        List r48 = CollectionsKt.listOf(r5);
        Map<String, List<String>> r49 = this.h;
        ContentType r50 = ContentType.LANGUAGE;
        r1[7] = new EnrichBotData(A((List) ((HashMap) r49).get(r50.getValue()), r48), null, r50.getValue(), r48, null, 18, null);
        r1[8] = null;
        r1[9] = null;
        return new BotEnrichParam(null, null, null, null, null, CollectionsKt.listOfNotNull(r1), new CreationIdInfo(getBotCreateTrace().d(), Integer.valueOf(r19)), 31, null);
    L145:
        r47 = null;
        goto L146
    L130:
        if (Intrinsics.areEqual(r44, TriggerSendLoading.NO_LOADING) == true) goto L139;
        List r51 = (List) ((HashMap) this.h).get(ContentType.VOICE_ID.getValue());
        if (r51 == null) goto L135;
        String r52 = (String) CollectionsKt.firstOrNull(r51);
    L137:
        if (Intrinsics.areEqual(r44, r52) == false) goto L140;
        r17 = ContentSource.MODEL_GENERATED;
        goto L140
    L135:
        r52 = null;
        goto L137
    L124:
        r44 = null;
        goto L125
    L141:
        r45 = null;
        goto L142
    L116:
        r116 = null;
        goto L117
    L112:
        r40 = null;
        goto L113
    L118:
        r42 = null;
        goto L119
    L106:
        r35 = null;
        goto L107
    L99:
        r31 = null;
        goto L100
    L80:
        if (r26 != null) goto L82;
    L84:
        r8 = false;
    L85:
        if (r8 == true) goto L87;
    L92:
        r27 = r17.getValue();
        goto L93
    L87:
        if (r26.containsAll(r23) == false) goto L92;
        if (this.r == false) goto L91;
        r27 = ContentSource.POLISH.getValue();
        goto L93
    L91:
        r27 = ContentSource.MODEL_GENERATED.getValue();
        goto L93
    L82:
        if (r26.size() != r23.size()) goto L84;
    L73:
        if (StringsKt.isBlank(r110) == true) goto L76;
        r111 = false;
        goto L77
    L57:
        r16 = null;
        goto L58
    L30:
        wu8.d r53 = this.i;
        if (r53 == null) goto L37;
        BgImage r54 = r53.b;
        if (r54 == null) goto L37;
        BgImageInfo r55 = r54.bgImageInfo;
        if (r55 == null) goto L37;
        String r56 = r55.bgImagePromptForEnrich;
    L38:
        if (r56 != null) goto L40;
        r56 = "";
    L40:
        List r57 = CollectionsKt.listOf(r56);
        BgImage r58 = a().getBgImage();
        if (r58 == null) goto L45;
        BgImageInfo r59 = r58.bgImageInfo;
        if (r59 == null) goto L45;
        String r60 = r59.bgImagePromptForEnrich;
    L46:
        if (r60 != null) goto L48;
        r60 = "";
    L48:
        String r117 = A(r57, CollectionsKt.listOf(r60));
        String r118 = ContentType.BG_IMG_PROMPT.getValue();
        BgImage r61 = a().getBgImage();
        if (r61 == null) goto L53;
        BgImageInfo r62 = r61.bgImageInfo;
        if (r62 == null) goto L53;
        String r63 = r62.bgImagePromptForEnrich;
    L54:
        r15 = new EnrichBotData(r117, null, r118, CollectionsKt.listOf(r63), null, 18, null);
    L53:
        r63 = null;
    L45:
        r60 = null;
    L37:
        r56 = null;
        goto L38
    L22:
        r13 = false;
        goto L23
    L14:
        r9 = false;
    L7:
        r4 = null;
        goto L8
    }

    public BotAutoFillViewModel(CoroutineScope r4, BotCreateViewModel$_autoFillModel$2$1 r5) {
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r5, "dependency");
        this.a = r5;
        this.b = r4;
        if (E() == false) goto L5;
        Visibility r0 = Visibility.VISIBLE;
    L6:
        StateFlowImpl r6 = j1.a(new c(new wu8.a(r0, new TextRes.StringResId(2131901080))));
        this.c = r6;
        this.d = kotlinx.coroutines.flow.e.b(r6);
        MutableSharedFlow<com.larus.bot.impl.feature.edit.feature.autofill.b> r7 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.e = r7;
        this.f = kotlinx.coroutines.flow.e.a(r7);
        this.g = new wu8.b();
        this.h = new HashMap();
        this.j = a();
        Lazy<UgcBotRepo> r8 = UgcBotRepo.d;
        this.n = UgcBotRepo.a.a();
        this.o = LazyKt.lazy(new h());
        this.p = LazyKt.lazy(new i());
        this.q = new AtomicBoolean(false);
        return;
    L5:
        r0 = Visibility.HIDDEN;
        goto L6
    }

    public static String A(List r2, List r3) {
        Integer r0 = null;
        if (r3 == null) goto L5;
        String r1 = (String) CollectionsKt.firstOrNull(r3);
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        ContentSource r5 = ContentSource.NOT_ENTERED;
    L30:
        return r5.getValue();
    L14:
        if (r2 == null) goto L16;
        Integer r6 = Integer.valueOf(r2.size());
    L17:
        if (r3 == null) goto L20;
        r0 = Integer.valueOf(r3.size());
    L20:
        if (Intrinsics.areEqual(r6, r0) == false) goto L28;
        if (r2 != null) goto L23;
        r2 = CollectionsKt.emptyList();
    L23:
        if (r3 != null) goto L26;
        r3 = CollectionsKt.emptyList();
    L26:
        if (r2.containsAll(r3) == false) goto L28;
        r5 = ContentSource.MODEL_GENERATED;
    L28:
        r5 = ContentSource.USER_INPUT;
        goto L30
    L16:
        r6 = null;
        goto L17
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r4 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static void D(BotAutoFillViewModel r4, AsyncThrowable r5) {
        int r0 = j0.a;
        String r1 = j0.d(2131897469);
        if (r4.q.compareAndSet(false, true) == false) goto L6;
        String r6 = lm9.e.a(r5, r1);
        Intrinsics.checkNotNullParameter(r6, "<this>");
        r4.L(new com.larus.bot.impl.feature.edit.feature.autofill.b.C0054b(new TextRes.PlainText(r6)));
        return;
    }

    public static final Object w(BotAutoFillViewModel r44, Continuation r45) {
        r44.getClass();
        if ((r45 instanceof BotAutoFillViewModel$requireEnrichBotInfo$1) == false) goto L7;
        BotAutoFillViewModel$requireEnrichBotInfo$1 r2 = (BotAutoFillViewModel$requireEnrichBotInfo$1) r45;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
    L52:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        BotEnrichParam r6 = (BotEnrichParam) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L44:
        if (r44.g.a == false) goto L47;
        r44.l = BuildersKt.launch$default(r44.b, Dispatchers.getIO(), null, new BotAutoFillViewModel$asyncRequireBotAvatar$1(r44, null), 2, null);
    L47:
        if (r44.g.b() == false) goto L52;
        e10 r7 = e10.a;
        int r8 = e10.F();
        r2.L$0 = null;
        r2.label = 2;
        if (r44.x(r6, 0, r8) != r4) goto L52;
        return r4;
    L16:
        ResultKt.throwOnFailure(r1);
        BotEditParam r9 = r44.a();
        Intrinsics.checkNotNullParameter(r9, "<this>");
        SpeakerVoice r10 = r9.getVoice();
        if (r10 == null) goto L19;
        SpeakerVoice r17 = SpeakerVoice.copy$default(r10, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, false, 0, 0, null, null, false, null, 0, null, 0, 0, 0.0f, 0.0f, null, false, null, null, Integer.MAX_VALUE, null);
    L20:
        BotLanguage r11 = r9.getLanguage();
        if (r11 == null) goto L23;
        BotLanguage r18 = BotLanguage.a(r11);
    L24:
        Triple<String, String, String> r12 = r9.getSuggests();
        if (r12 == null) goto L27;
        Triple r28 = Triple.copy$default(r12, null, null, null, 7, null);
    L28:
        ModelItem r29 = r9.getModelItem();
        if (r29 == null) goto L31;
        ModelItem r24 = ModelItem.copy$default(r29, null, 0, null, null, null, null, 63, null);
    L32:
        BgImage r13 = r9.getBgImage();
        if (r13 == null) goto L39;
        BgImageInfo r14 = r13.bgImageInfo;
        if (r14 == null) goto L37;
        BgImageInfo r15 = BgImageInfo.copy$default(r14, null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    L38:
        BgImage r210 = BgImage.copy$default(r13, null, null, null, r15, 7, null);
    L40:
        r44.j = BotEditParam.copy$default(r9, null, null, null, null, null, null, 0, r17, r18, null, null, false, null, null, r24, null, null, null, r28, r210, null, null, null, null, null, 32751231, null);
        int r16 = r44.t + 1;
        r44.t = r16;
        r6 = r44.z(r16);
        r44.J(Visibility.DISABLE, new TextRes.StringResId(2131901137));
        r2.L$0 = r6;
        r2.label = 1;
        if (r44.K(r6, r2) != r4) goto L44;
        return r4;
    L37:
        r15 = null;
        goto L38
    L39:
        r210 = null;
        goto L40
    L31:
        r24 = null;
        goto L32
    L27:
        r28 = null;
        goto L28
    L23:
        r18 = null;
        goto L24
    L19:
        r17 = null;
    L7:
        r2 = new BotAutoFillViewModel$requireEnrichBotInfo$1(r44, r45);
        goto L8
    }

    public final Object C(wu8.d r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof BotAutoFillViewModel$handleGenAvatarSuccess$1) == false) goto L7;
        BotAutoFillViewModel$handleGenAvatarSuccess$1 r0 = (BotAutoFillViewModel$handleGenAvatarSuccess$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (wu8.d) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L24:
        m(CollectionsKt.listOf(new wu8.c.a(r7)));
        this.i = r7;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        String[] r10 = new String[2];
        BgImage r4 = r7.b;
        String r5 = null;
        if (r4 == null) goto L17;
        String r6 = r4.bgImgUrl;
    L18:
        r10[0] = r6;
        BotAvatarIconData r11 = r7.a;
        if (r11 == null) goto L21;
        r5 = r11.getIconUrl();
    L21:
        r10[1] = r5;
        List r12 = CollectionsKt.listOf(r10);
        r0.L$0 = r7;
        r0.label = 1;
        if (BitmapHelperKt.f(r12, r0) != r2) goto L24;
        return r2;
    L17:
        r6 = null;
    L7:
        r0 = new BotAutoFillViewModel$handleGenAvatarSuccess$1(this, r8);
        goto L8
    }

    public final void J(Visibility r4, TextRes.StringResId r5) {
        StateFlowImpl r0 = this.c;
        c r1 = (c) this.d.getValue();
        ((c) this.d.getValue()).a.getClass();
        Intrinsics.checkNotNullParameter(r4, "visibility");
        Intrinsics.checkNotNullParameter(r5, ShareType.TEXT);
        wu8.a r2 = new wu8.a(r4, r5);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "autoFillBtnUIState");
        r0.setValue(new c(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.List] */
    public final Object K(BotEnrichParam r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof BotAutoFillViewModel$requireEnrichCheck$1) == false) goto L7;
        BotAutoFillViewModel$requireEnrichCheck$1 r0 = (BotAutoFillViewModel$requireEnrichCheck$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Object r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
    L17:
        y r12 = (com.larus.network.http.a) r11;
        boolean r5 = false;
        if ((r12 instanceof y) == false) goto L81;
        y r13 = r12;
        List r6 = (List) ((com.larus.network.http.a) r13).b;
        if (r6 == null) goto L34;
        Iterator r7 = r6.iterator();
    L23:
        if (r7.hasNext() == false) goto L32;
        Object r8 = r7.next();
        EnrichBotData r14 = (EnrichBotData) r8;
        if (o0.d(r14.contentType) == true) goto L27;
    L29:
        boolean r15 = false;
    L30:
        if (r15 == false) goto L23;
    L33:
        EnrichBotData r16 = (EnrichBotData) r8;
    L35:
        if (r16 == null) goto L81;
        List r17 = (List) ((com.larus.network.http.a) r13).b;
        if (r17 == null) goto L49;
        ?? r18 = new ArrayList();
        Iterator r19 = r17.iterator();
    L40:
        if (r19.hasNext() == false) goto L50;
        Object r20 = r19.next();
        EnrichBotData r21 = (EnrichBotData) r20;
        if (o0.d(r21.contentType) == true) goto L44;
    L46:
        boolean r22 = false;
    L47:
        if (r22 == false) goto L40;
        r18.add(r20);
        goto L40
    L44:
        if (Intrinsics.areEqual(r21.operateType, OperateType.OVERRIDABLE.getValue()) == false) goto L46;
        r22 = true;
    L50:
        if (r18 != 0) goto L52;
        r18 = CollectionsKt.emptyList();
    L52:
        wu8.b r110 = this.g;
        r110.a = false;
        r110.b = false;
        r110.c = false;
        r110.d = false;
        r110.e = false;
        r110.f = false;
        r110.g = false;
        r110.h = false;
        List r23 = (List) ((com.larus.network.http.a) r13).b;
        if (r23 == null) goto L66;
        Iterator r24 = r23.iterator();
    L56:
        if (r24.hasNext() == false) goto L65;
        Object r111 = r24.next();
        EnrichBotData r25 = (EnrichBotData) r111;
        List r26 = CollectionsKt.listOf(new ContentType[]{ContentType.HEAD_IMG_PROMPT, ContentType.BG_IMG_PROMPT});
        ContentType.a r27 = ContentType.Companion;
        String r28 = r25.contentType;
        r27.getClass();
        if (r26.contains(ContentType.a.a(r28)) == true) goto L60;
    L62:
        boolean r29 = false;
    L63:
        if (r29 == false) goto L56;
        r4 = r111;
        goto L65
    L60:
        if (Intrinsics.areEqual(r25.operateType, OperateType.NON_OVERRIDABLE.getValue()) == false) goto L62;
        r29 = true;
    L65:
        r4 = (EnrichBotData) r4;
    L66:
        if (r4 != null) goto L68;
        r5 = true;
    L68:
        this.g.a = r5;
        Iterator r30 = ((Iterable) r18).iterator();
    L70:
        if (r30.hasNext() == false) goto L80;
        EnrichBotData r112 = (EnrichBotData) r30.next();
        ContentType.a r31 = ContentType.Companion;
        String r113 = r112.contentType;
        r31.getClass();
        switch(b.a[ContentType.a.a(r113).ordinal()]) {
            case 1: goto L79;
            case 2: goto L78;
            case 3: goto L77;
            case 4: goto L76;
            case 5: goto L75;
            case 6: goto L74;
            default: goto L70;
        };
    L74:
        this.g.g = j().d();
        goto L70
    L75:
        this.g.f = j().a();
        goto L70
    L76:
        this.g.h = j().b();
        goto L70
    L77:
        this.g.e = j().c();
        goto L70
    L78:
        this.g.c = true;
        goto L70
    L79:
        this.g.b = true;
        goto L70
    L80:
        b();
    L107:
        I();
        return Unit.INSTANCE;
    L49:
        r18 = 0;
        goto L50
    L27:
        if (Intrinsics.areEqual(r14.operateType, OperateType.OVERRIDABLE.getValue()) == false) goto L29;
        r15 = true;
        goto L30
    L32:
        r8 = null;
        goto L33
    L34:
        r16 = null;
    L81:
        FLogger r32 = FLogger.a;
        StringBuilder r33 = new StringBuilder("something went wrong when requireBotEnrichCheck, errorCode: ");
        if ((r12 instanceof com.larus.network.http.f) == false) goto L84;
        com.larus.network.http.f r114 = (com.larus.network.http.f) r12;
    L85:
        if (r114 == null) goto L89;
        AsyncThrowable r115 = r114.d;
        if (r115 == null) goto L89;
        r4 = Boxing.boxLong(r115.getCode());
    L89:
        r33.append(r4);
        r32.e("BotAutoFillViewModel", r33.toString());
        r32.i("BotAutoFillViewModel", "showGeneratingAll");
        wu8.b r34 = this.g;
        r34.a = true;
        r34.b = true;
        r34.c = true;
        r34.e = true;
        r34.f = true;
        r34.g = true;
        r34.h = true;
        if (j().c() == true) goto L93;
        this.g.e = false;
    L93:
        if (j().b() == true) goto L96;
        this.g.h = false;
    L96:
        if (j().a() == true) goto L99;
        this.g.f = false;
    L99:
        if (j().d() == true) goto L102;
        this.g.g = false;
    L102:
        if (o0.d(a().getIconUri()) == true) goto L104;
    L106:
        b();
        goto L107
    L104:
        if (F() == true) goto L106;
        this.g.a = false;
        goto L106
    L84:
        r114 = null;
        goto L85
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        BotAutoFillViewModel$requireEnrichCheck$resp$1 r116 = new BotAutoFillViewModel$requireEnrichCheck$resp$1(this, r9, null);
        r0.label = 1;
        r11 = TimeoutKt.c(5000, r116, r0);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new BotAutoFillViewModel$requireEnrichCheck$1(this, r10);
        goto L8
    }

    @Override // wu8.f
    public final void c(ContentType r11, boolean r12) {
        boolean r0 = false;
        if (r11 == null) goto L35;
        switch(b.a[r11.ordinal()]) {
            case 1: goto L31;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L18;
            case 7: goto L15;
            case 8: goto L15;
            case 9: goto L7;
            default: goto L35;
        };
    L7:
        if (r12 == true) goto L35;
        Map<String, List<String>> r13 = this.h;
        String r14 = ContentType.LANGUAGE.getValue();
        BotLanguage r2 = a().getLanguage();
        if (r2 == null) goto L11;
        String r3 = r2.c();
    L12:
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        ((HashMap) r13).put(r14, CollectionsKt.listOf(r3));
        goto L35
    L11:
        r3 = null;
        goto L12
    L15:
        if (r12 == true) goto L17;
        this.i = new wu8.d(new BotAvatarIconData(a().getIconUri(), a().getIconUrl(), null, null, null, 28, null), a().getBgImage());
    L17:
        this.g.a = false;
        goto L35
    L18:
        if (r12 == true) goto L24;
        Map<String, List<String>> r15 = this.h;
        String r16 = ContentType.VOICE_ID.getValue();
        SpeakerVoice r4 = a().getVoice();
        if (r4 == null) goto L22;
        String r5 = r4.getId();
    L23:
        ((HashMap) r15).put(r16, CollectionsKt.listOf(r5));
        goto L24
    L22:
        r5 = null;
    L24:
        this.g.g = false;
        goto L35
    L25:
        this.g.f = false;
        goto L35
    L26:
        this.g.h = false;
        goto L35
    L27:
        this.g.e = false;
        goto L35
    L28:
        if (r12 == true) goto L30;
        ((HashMap) this.h).put(ContentType.DESC.getValue(), CollectionsKt.listOf(a().getDescription()));
    L30:
        this.g.c = false;
        goto L35
    L31:
        if (r12 == true) goto L33;
        ((HashMap) this.h).put(ContentType.NAME.getValue(), CollectionsKt.listOf(a().getName()));
    L33:
        this.g.b = false;
    L35:
        if (this.g.a == true) goto L46;
        Job r17 = this.l;
        if (r17 != null) goto L39;
    L44:
        this.l = null;
        goto L46
    L39:
        if (true != r17.isActive()) goto L41;
        boolean r6 = true;
    L42:
        if (r6 == false) goto L44;
        Job.DefaultImpls.cancel$default(r17, null, 1, null);
        goto L44
    L41:
        r6 = false;
    L46:
        if (this.g.b() == true) goto L55;
        Job r18 = this.m;
        if (r18 != null) goto L50;
    L54:
        this.m = null;
        goto L55
    L50:
        if (true != r18.isActive()) goto L52;
        r0 = true;
    L52:
        if (r0 == false) goto L54;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);
    L55:
        b();
        I();
    }

    public static final Object v(BotAutoFillViewModel r37, com.larus.network.http.a r38, Continuation r39) {
        com.larus.network.http.a r0 = r38;
        r37.getClass();
        if ((r39 instanceof BotAutoFillViewModel$handleGenerateIconByPromptSuccess$1) == false) goto L7;
        BotAutoFillViewModel$handleGenerateIconByPromptSuccess$1 r3 = (BotAutoFillViewModel$handleGenerateIconByPromptSuccess$1) r39;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        String r16 = "bot_create_auto_fill";
        String r17 = "gen_icon_by_prompt";
        String r10 = "bot_create/autofill/bg";
        if (r5 == 0) goto L24;
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L22;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L16;
        ResultKt.throwOnFailure(r2);
        r10 = "bot_create/autofill/bg";
        r16 = r16;
        r17 = r17;
        long r6 = 0;
    L137:
        qu8.b.d(r17, r6);
        qu8.b.d(r10, r6);
        if (r37.g.b() == true) goto L144;
        qu8.b.d(r16, r6);
    L144:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        BotAvatarIconData r7 = (BotAvatarIconData) r3.L$1;
        com.larus.network.http.a r8 = (com.larus.network.http.a) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L20
        Object r1 = r2;
        String r20 = "upload_file";
        r10 = "bot_create/autofill/bg";
        r16 = r16;
        r17 = r17;
        ImageUploadResult r9 = null;
        boolean r18 = true;
    L149:
        Object r11 = Result.constructor-impl((ImageUploadResult) ((com.larus.network.http.a) r1).b);     // Catch: Throwable -> L70
    L78:
        Object r13 = r11;
        if (Result.isFailure-impl(r13) == false) goto L81;
        r13 = r9;
    L81:
        ImageUploadResult r14 = (ImageUploadResult) r13;
        if (r14 != null) goto L84;
        qu8.b.d(r20, -2);
        r6 = 0;
    L91:
        if (r37.g.a == false) goto L137;
        if (r14 == null) goto L95;
        ImageUploadResult r15 = r14.getUploadUrl();
    L97:
        if (o0.d(r15) == false) goto L111;
        if (r14 == null) goto L100;
        ImageUploadResult r19 = r14.getUploadUri();
    L102:
        if (o0.d(r19) == false) goto L111;
        if (r14 == null) goto L106;
        ImageUploadResult r23 = r14.getUploadUri();
    L107:
        if (r14 == null) goto L109;
        ImageUploadResult r24 = r14.getUploadUrl();
    L110:
        BotAvatarIconData r21 = new BotAvatarIconData(r23, r24, null, null, null, 28, null);
    L113:
        if (r7 == null) goto L115;
        ImageUploadResult r110 = r7.getIconUri();
    L116:
        if (r7 == null) goto L118;
        ImageUploadResult r111 = r7.getIconUrl();
    L119:
        BotGenBgImageResponse r112 = (BotGenBgImageResponse) r8.b;
        if (r112 == null) goto L122;
        ImageUploadResult r25 = r112.getBgImgPrompt();
    L123:
        BotGenBgImageResponse r113 = (BotGenBgImageResponse) r8.b;
        if (r113 == null) goto L126;
        ImageUploadResult r26 = r113.getBgImgPromptEn();
    L127:
        BotGenBgImageResponse r22 = (BotGenBgImageResponse) r8.b;
        if (r22 == null) goto L130;
        ImageUploadResult r27 = r22.getBgImgOpen();
    L131:
        if (r7 == null) goto L133;
        ImageUploadResult r33 = r7.getPrompt();
    L134:
        wu8.d r28 = new wu8.d(r21, new BgImage(r110, r111, r9, new BgImageInfo(r25, r26, Boxing.boxBoolean(r18), null, r27, null, null, null, null, null, r33, GuidePriority.COMMERCE_CREDIT_PRIORITY, null)));
        r3.L$0 = r9;
        r3.L$1 = r9;
        r3.label = 4;
        if (r37.C(r28, r3) != r12) goto L137;
        return r12;
    L133:
        r33 = r9;
        goto L134
    L130:
        r27 = r9;
        goto L131
    L126:
        r26 = r9;
        goto L127
    L122:
        r25 = r9;
        goto L123
    L118:
        r111 = r9;
        goto L119
    L115:
        r110 = r9;
        goto L116
    L109:
        r24 = r9;
        goto L110
    L106:
        r23 = r9;
        goto L107
    L100:
        r19 = r9;
    L111:
        r21 = r7;
        goto L113
    L95:
        r15 = r9;
        goto L97
    L84:
        r6 = 0;
        qu8.b.d(r20, 0);
    L70:
        th = th;
    L77:
        Result.Companion r29 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L20:
        th = th;
        r20 = "upload_file";
        r10 = "bot_create/autofill/bg";
        r16 = r16;
        r17 = r17;
        r9 = null;
        r18 = true;
        goto L77
    L22:
        BotAvatarIconData r30 = (BotAvatarIconData) r3.L$1;
        com.larus.network.http.a r31 = (com.larus.network.http.a) r3.L$0;
        ResultKt.throwOnFailure(r2);
        BotAvatarIconData r114 = r30;
        ImageUploadResult r32 = null;
        long r115 = 0;
        Object r34 = r2;
        com.larus.network.http.a r35 = r31;
    L59:
        File r36 = (File) r34;
        if (r36 == null) goto L85;
        qu8.b.e("upload_file", "bot_create/autofill/bg", false);
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L74
        BotImageUploadViewModel r41 = (BotImageUploadViewModel) r37.p.getValue();     // Catch: Throwable -> L74
        Uri r42 = Uri.fromFile(r36);     // Catch: Throwable -> L74
        r3.L$0 = r35;     // Catch: Throwable -> L74
        r3.L$1 = r114;     // Catch: Throwable -> L74
        r3.label = 3;     // Catch: Throwable -> L74
        r20 = "upload_file";
        r16 = r16;
        r17 = r17;
        ImageUploadResult r116 = r32;
        r10 = "bot_create/autofill/bg";
        com.larus.network.http.a r117 = r35;
        r9 = r116;
        r18 = true;
        r1 = BotImageUploadViewModel.syncUpload$default(r41, r42, 0, null, false, r3, 14, null);     // Catch: Throwable -> L72
        if (r1 == r12) goto L155;
        r7 = r114;
        r8 = r117;
        goto L149
    L155:
        return r12;
    L72:
        th = th;
    L76:
        r7 = r114;
        r8 = r117;
    L74:
        th = th;
        r20 = "upload_file";
        r10 = "bot_create/autofill/bg";
        r16 = r16;
        r17 = r17;
        r18 = true;
        r117 = r35;
        r9 = r32;
        goto L76
    L85:
        r10 = "bot_create/autofill/bg";
        r6 = r115;
        r16 = r16;
        r17 = r17;
        r18 = true;
        com.larus.network.http.a r118 = r35;
        r9 = r32;
        r7 = r114;
        r0 = r118;
    L89:
        r8 = r0;
        r14 = r9;
        goto L91
    L23:
        BotAvatarIconData r43 = (BotAvatarIconData) r3.L$1;
        com.larus.network.http.a r44 = (com.larus.network.http.a) r3.L$0;
        ResultKt.throwOnFailure(r2);
        BotAvatarIconData r45 = r43;
        r0 = r44;
        Object r46 = r2;
    L49:
        Bitmap r47 = (Bitmap) r46;
        if (r47 != null) goto L52;
        qu8.b.d("avatar_head_location_crop", -2);
        r115 = 0;
    L54:
        if (r47 == null) goto L86;
        r3.L$0 = r0;
        r3.L$1 = r45;
        r3.label = 2;
        r32 = null;
        r34 = BitmapHelperKt.g(null, r47, BgSelectViewModel.AVATAR_BITMAP_CACHE_FILE_NAME, r3);
        if (r34 == r12) goto L154;
        r114 = r45;
        r35 = r0;
        goto L59
    L154:
        return r12;
    L86:
        r7 = r45;
        r6 = r115;
        r9 = null;
    L87:
        r18 = true;
        goto L89
    L52:
        r115 = 0;
        qu8.b.d("avatar_head_location_crop", 0);
        goto L54
    L24:
        ResultKt.throwOnFailure(r2);
        BotGenBgImageResponse r48 = (BotGenBgImageResponse) r0.b;
        if (r48 == null) goto L29;
        List<BotAvatarIconData> r49 = r48.getBgImgList();
        if (r49 == null) goto L29;
        r45 = (BotAvatarIconData) CollectionsKt.firstOrNull(r49);
    L30:
        if (r45 == null) goto L32;
        String r50 = r45.getIconUri();
    L34:
        if (o0.d(r50) == false) goto L140;
        if (r45 == null) goto L37;
        String r51 = r45.getIconUrl();
    L39:
        if (o0.d(r51) == false) goto L140;
        FLogger.a.i("BotAutoFillViewModel", "generateIconByPrompt, success");
        if (r45 == null) goto L88;
        String r52 = r45.getIconUrl();
        if (r52 == null) goto L88;
        String r53 = r45.getIconUri();
        if (r53 == null) goto L53;
        qu8.b.e("avatar_head_location_crop", "bot_create/autofill/bg", false);
        AIGenBgImageRepository r119 = (AIGenBgImageRepository) r37.o.getValue();
        r3.L$0 = r0;
        r3.L$1 = r45;
        r3.label = 1;
        r46 = r119.a(r53, r52, new com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.a(), r3);
        if (r46 != r12) goto L49;
        return r12;
    L53:
        r115 = 0;
        r47 = null;
    L88:
        r7 = r45;
        r9 = null;
        r6 = 0;
        goto L87
    L37:
        r51 = null;
    L140:
        r37.B(null);
        qu8.b.d(r17, 30021);
        qu8.b.d("bot_create/autofill/bg", 30021);
        if (r37.g.b() == true) goto L144;
        qu8.b.d(r16, 3002);
        goto L144
    L32:
        r50 = null;
    L29:
        r45 = null;
    L7:
        r3 = new BotAutoFillViewModel$handleGenerateIconByPromptSuccess$1(r37, r39);
        goto L8
    }

    public final Unit x(BotEnrichParam r13, int r14, int r15) {
        FLogger.a.i("BotAutoFillViewModel", "asyncRequireEnrichInfo, curRetryCount = " + r14 + ", maxRetryCount = " + r15);
        if (r14 != 0) goto L5;
        qu8.b.e("enrich", "bot_create_auto_fill", false);
    L5:
        this.m = BuildersKt.launch$default(this.b, null, null, new BotAutoFillViewModel$asyncRequireEnrichInfo$2(this, r13, r14, r15, null), 3, null);
        return Unit.INSTANCE;
    }

    public static final Object t(BotAutoFillViewModel r10, String r11, String r12, String r13, int r14, int r15, Continuation r16) {
        r10.getClass();
        Object r0 = BuildersKt.withContext(Dispatchers.getIO(), new BotAutoFillViewModel$generateIcon$2(r11, r12, r14, r15, r10, r13, null), r16);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r0;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object u(BotAutoFillViewModel r11, String r12, String r13, String r14, String r15, int r16, int r17, Continuation r18) {
        r11.getClass();
        Object r0 = BuildersKt.withContext(Dispatchers.getIO(), new BotAutoFillViewModel$generateIconByPrompt$2(r16, r17, r11, r12, r13, r14, r15, null), r18);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r0;
    L6:
        return Unit.INSTANCE;
    }
}
