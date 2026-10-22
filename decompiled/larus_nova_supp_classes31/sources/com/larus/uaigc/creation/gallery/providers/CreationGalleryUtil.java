package com.larus.uaigc.creation.gallery.providers;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.bigimg.AwemeImageFilter;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.search.SourceFrom;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.utils.IVideoShareService;
import com.larus.bmhome.utils.c4;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.a5;
import hq9.v1;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationGalleryUtil {
    public static final CreationGalleryUtil a = null;
    public static final Lazy b = null;

    public CreationGalleryUtil() {
    }

    static {
        a = new CreationGalleryUtil();
        b = LazyKt.lazy(new l());
    }

    public static String d(Integer r2) {
        if (r2 != null) goto L5;
    L7:
        if (r2 != null) goto L10;
    L12:
        if (r2 != null) goto L15;
    L17:
        return "";
    L15:
        if (r2.intValue() != 3) goto L17;
        return "1";
    L10:
        if (r2.intValue() != 2) goto L12;
        return "0";
    L5:
        if (r2.intValue() != 1) goto L7;
        return "-1";
    }

    public static boolean j(Integer r4) {
        z2 r0 = z2.a;
        v1 r1 = r0.getCreationShareSettings().a();
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L26;
        v1 r3 = r0.getCreationShareSettings().a();
        if (r3 != null) goto L12;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == true) goto L21;
        if (r4 == null) goto L21;
        if (r4.intValue() != 2) goto L21;
        boolean r6 = false;
    L23:
        if (r6 == false) goto L27;
        return true;
    L27:
        return false;
    L21:
        r6 = true;
        goto L23
    L12:
        if (r3.f() != true) goto L14;
        r5 = true;
        goto L15
    L26:
        return false;
    L5:
        if (r1.e() != true) goto L7;
        r2 = true;
        goto L8
    }

    public static final com.larus.bmhome.share.panel.h b(String r77, sz9.c r78) {
        JSONObject r8 = r78.f;
        Integer r1 = r78.c;
        if (r1 != null) goto L6;
    L8:
        boolean r10 = false;
    L9:
        Message r2 = r78.l;
        if (r2 == null) goto L12;
        String r7 = r2.getMessageId();
    L13:
        Integer r11 = r78.c;
        String r25 = AccountService.a.getUserId();
        Message r15 = r78.l;
        String r4 = r78.j;
        String r16 = f(r8, "template_rec_req_id");
        String r17 = f(r8, "template_rec_extra");
        String r18 = f(r8, "from_template_id");
        String r39 = f(r8, "recommend_from");
        Message r3 = r78.l;
        if (r3 == null) goto L16;
        String r63 = com.larus.im.bean.message.a.r(r3);
    L17:
        Message r0 = r78.l;
        if (r0 == null) goto L20;
        String r64 = com.larus.im.bean.message.a.s(r0);
    L22:
        return new com.larus.bmhome.share.panel.h(null, null, null, r77, null, null, r7, r8, null, r10, r11, null, null, null, r16, r17, r18, r39, null, null, null, null, null, null, r25, null, null, null, null, null, null, null, null, null, null, null, null, null, r15, null, null, r4, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r63, r64, null, null, false, null, null, null, null, -68098449, -4353, 1017);
    L20:
        r64 = null;
        goto L22
    L16:
        r63 = null;
        goto L17
    L12:
        r7 = null;
        goto L13
    L6:
        if (r1.intValue() != 3) goto L8;
        r10 = true;
        goto L9
    }

    public static String f(JSONObject r1, String r2) {
        if (r1 == null) goto L13;
        String r3 = r1.optString(r2);
        if (r3 == null) goto L13;
        boolean r0 = true;
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
    L10:
        r0 = false;
    L11:
        if (r0 == false) goto L13;
        return r3;
    L8:
        if (Intrinsics.areEqual(r3, "null") == true) goto L10;
    L13:
        return null;
    }

    public static void i(sz9.c r18, View r19, l0 r20) {
        Intrinsics.checkNotNullParameter(r18, "params");
        a5 r0 = z2.a.getCreationShareSettings().c();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.a() != true) goto L7;
    L8:
        c4 r2 = r18.n;
        String r3 = null;
        if (r2 == null) goto L11;
        String r4 = r2.g;
    L12:
        boolean r5 = Intrinsics.areEqual(r4, "1");
        if (r5 == false) goto L15;
        ShareScene r6 = ShareScene.VIDEO_COMPREHEND;
    L16:
        ShareScene r11 = r6;
        nr9.g r9 = r18.h;
        if (r1 == false) goto L22;
        if (r5 == true) goto L22;
        CoroutineScope r7 = r18.k;
        if (r7 == null) goto L32;
        BuildersKt.launch$default(r7, null, null, new CreationGalleryUtil$shareVideo$1(r19, r9, r18, r20, r11, null), 3, null);
        return;
    L32:
        return;
    L22:
        IVideoShareService r8 = (IVideoShareService) ServiceManager.get().getService(IVideoShareService.class);
        if (r8 == null) goto L34;
        CoroutineScope r10 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        Message r12 = r18.l;
        if (r12 == null) goto L27;
        r3 = r12.getMessageId();
    L27:
        if (r3 != null) goto L29;
        String r13 = "";
    L30:
        IVideoShareService.a.b(r8, r19, r10, r20, r9, r13, r11, r18.m, r18.n, null, null, r18.q, 1280);
        return;
    L29:
        r13 = r3;
        goto L30
    L34:
        return;
    L15:
        r6 = ShareScene.VIDEO_VIEWER;
        goto L16
    L11:
        r4 = null;
    L7:
        r1 = false;
        goto L8
    }

    public final Object e(String r7, String r8, Continuation<? super UserCreationFromIM> r9) {
        if ((r9 instanceof CreationGalleryUtil$getLatestUserCreation$1) == false) goto L7;
        CreationGalleryUtil$getLatestUserCreation$1 r0 = (CreationGalleryUtil$getLatestUserCreation$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = "";
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r11 = (String) r0.L$1;
        String r12 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
        r8 = r11;
        r7 = r12;
    L32:
        String r5 = (String) r10;
    L33:
        if (r5 == null) goto L37;
        r4 = r5;
    L37:
        return ((LinkedHashMap) DataConverterKt.c(r4, r7)).get(r8);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (r7 != null) goto L17;
    L20:
        boolean r13 = true;
    L21:
        r5 = null;
        if (r13 == false) goto L24;
        return null;
    L24:
        IChatRepoService r14 = RepoDispatcherDelegate.b.e();
        if (r14 == null) goto L33;
        if (r7 != null) goto L28;
        String r6 = "";
    L29:
        r0.L$0 = r7;
        r0.L$1 = r8;
        r0.label = 1;
        r10 = r14.w1(r6, r0);
        if (r10 != r2) goto L32;
        return r2;
    L28:
        r6 = r7;
        goto L29
    L17:
        if (r7.length() == 0) goto L20;
        r13 = false;
    L7:
        r0 = new CreationGalleryUtil$getLatestUserCreation$1(this, r9);
        goto L8
    }

    public static void c(final Context r12, final sz9.c r13, View r14, final Function2 r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r14, "rootView");
        Integer r0 = r13.c;
        z2 r1 = z2.a;
        v1 r2 = r1.getCreationShareSettings().a();
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L9:
        if (r3 == false) goto L34;
        v1 r4 = r1.getCreationShareSettings().a();
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L22;
        if (r0 != null) goto L20;
    L30:
        boolean r6 = true;
    L32:
        if (r6 == false) goto L34;
        boolean r7 = true;
    L35:
        FragmentActivity r8 = null;
        if (r7 == false) goto L40;
        CoroutineScope r9 = r13.k;
        if (r9 == null) goto L97;
        BuildersKt.launch$default(r9, null, null, new CreationGalleryUtil$showCreationShare$1(r14, r13, "download", null), 3, null);
        return;
    L97:
        return;
    L40:
        com.larus.platform.service.o r16 = com.larus.platform.service.o.a;
        JSONObject r10 = r13.f;
        if (r10 == null) goto L81;
        Integer r11 = r13.c;
        if (r11 != null) goto L46;
    L48:
        int r17 = 0;
    L49:
        r10.put("is_image_edit", r17);
        r10.put("click_from", "click_download");
        r10.put("click_method", "detail_click");
        Integer r18 = r13.c;
        if (r18 != null) goto L53;
    L55:
        int r19 = 0;
    L56:
        r10.put("is_replica_gen", r19);
        com.larus.bmhome.share.panel.h r20 = r13.m;
        if (r20 == null) goto L63;
        String r21 = r20.n0;
        if (r21 == null) goto L63;
        if (o0.d(r21) == false) goto L63;
        r10.put("is_general_agent", r21);
    L63:
        com.larus.bmhome.share.panel.h r22 = r13.m;
        if (r22 == null) goto L70;
        String r23 = r22.o0;
        if (r23 == null) goto L70;
        if (o0.d(r23) == false) goto L70;
        r10.put("chat_id", r23);
    L70:
        r10.put("is_ai_creation", 1);
        n1 r24 = r13.a;
        if (r24 == null) goto L73;
        String r25 = r24.e;
    L74:
        if (r25 != null) goto L76;
    L79:
        int r26 = 1;
    L80:
        r10.put("has_original_image", r26 ^ 1);
        r10.put("download_method", "click_icon");
        r10.put("is_search_card", 0);
        r10.put("creation_id", r13.j);
        Unit r27 = Unit.INSTANCE;
    L82:
        r16.reportEvent("picture_download", r10);
        Uri r110 = r13.b;
        if (r110 != null) goto L85;
        return;
    L85:
        final String r28 = r110.toString();
        if (Build.VERSION.SDK_INT <= 29) goto L88;
    L95:
        h(r28, false, r13, r12, "saveBitmapWithCheckWatermark", r15);
        return;
    L88:
        if (ContextCompat.checkSelfPermission(r12, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L95;
        if ((r12 instanceof FragmentActivity) == false) goto L92;
        r8 = (FragmentActivity) r12;
    L92:
        if (r8 != null) goto L94;
        return;
    L94:
        i2.b.a(r8, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new o(r28, r13, r12, r15));
        return;
    L76:
        if (StringsKt.isBlank(r25) == true) goto L79;
        r26 = 0;
        goto L80
    L73:
        r25 = null;
        goto L74
    L53:
        if (r18.intValue() != 3) goto L55;
        r19 = 1;
        goto L56
    L46:
        if (r11.intValue() != 4) goto L48;
        r17 = 1;
        goto L49
    L81:
        r10 = null;
        goto L82
    L20:
        if (r0.intValue() != 3) goto L30;
    L31:
        r6 = false;
        goto L32
    L22:
        if (r0 != null) goto L25;
    L26:
        if (r0 == null) goto L30;
        if (r0.intValue() == 2) goto L31;
    L25:
        if (r0.intValue() == 3) goto L31;
    L13:
        if (r4.f() != true) goto L15;
        r5 = true;
    L34:
        r7 = false;
        goto L35
    L5:
        if (r2.b() != true) goto L7;
        r3 = true;
        goto L9
    }

    public static final Object a(CreationGalleryUtil r4, String r5, String r6, String r7, Continuation r8) {
        r4.getClass();
        if ((r8 instanceof CreationGalleryUtil$getMetaDataMap$1) == false) goto L7;
        CreationGalleryUtil$getMetaDataMap$1 r0 = (CreationGalleryUtil$getMetaDataMap$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L17:
        ICreationMetadataService.Companion r10 = ICreationMetadataService.a;
        return r10.s((UserCreationFromIM) r9, r7);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r0.L$0 = r7;
        r0.label = 1;
        r9 = r4.e(r5, r6, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new CreationGalleryUtil$getMetaDataMap$1(r4, r8);
        goto L8
    }

    public static void g(String r11, boolean r12, sz9.c r13, Context r14, Function2 r15) {
        CoroutineScope r0 = r13.k;
        if (r0 == null) goto L6;
        BuildersKt.launch$default(r0, null, null, new CreationGalleryUtil$saveBitmap$1(r12, r13, r14, r11, r15, null), 3, null);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.uaigc.creation.gallery.providers.m] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.uaigc.creation.gallery.providers.n] */
    public static void h(String r8, final boolean r9, final sz9.c r10, final Context r11, final String r12, final Function2 r13) {
        if (r10.p == false) goto L6;
        g(r8, r9, r10, r11, r13);
        return;
    L6:
        final ?? r0 = new m(r9, r10, r11, r13);
        final ?? r1 = new n(r12);
        com.larus.bmhome.bigimg.l r14 = r10.d;
        if (r14 == null) goto L14;
        Integer r2 = r14.h;
        int r3 = SourceFrom.DouYin.value;
        if (r2 == null) goto L14;
        if (r2.intValue() != r3) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L17;
        g(r8, r9, r10, r11, r13);
        Unit r15 = Unit.INSTANCE;
        return;
    L17:
        AwemeImageFilter r5 = (AwemeImageFilter) b.getValue();
        String r16 = null;
        if (r14 == null) goto L20;
        String r6 = r14.a;
    L21:
        if (r14 == null) goto L23;
        String r7 = r14.c;
    L24:
        if (r14 == null) goto L26;
        r16 = r14.e;
    L26:
        r5.a(r6, r7, r16, new p(r0), new q(r1));
        return;
    L23:
        r7 = null;
        goto L24
    L20:
        r6 = null;
    L14:
        r4 = false;
        goto L15
    }
}
