package com.larus.bmhome.music.edit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.music.protocol.UpdateBigMusicMessageApi;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.network.FlowHttpConnection;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.ModifiedUserCreationContent;
import com.larus.platform.api.ModifiedUserCreationMusic;
import com.larus.platform.api.ModifiedUserCreationResponse;
import com.larus.platform.service.e0;
import com.larus.utils.logger.FLogger;
import com.yalantis.ucrop.UCropActivity;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MusicInfoEditHelper {
    public static final MusicInfoEditHelper a = null;

    static {
        a = new MusicInfoEditHelper();
    }

    public MusicInfoEditHelper() {
    }

    public static ActivityResultLauncher h(final Fragment r3, final a r4) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "callback");
        FLogger.a.i("MusicInfoEditHelper", "[registerEditCoverLauncher] host:" + Reflection.getOrCreateKotlinClass(r3.getClass()).getSimpleName() + '_' + r3.hashCode());
        final ActivityResultLauncher r5 = r3.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new m(r3, r4));
        return r3.registerForActivityResult(new ActivityResultContracts.GetContent(), new n(r3, r5));
    }

    public static ActivityResultLauncher i(final Fragment r3, final a r4) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "callback");
        FLogger.a.i("MusicInfoEditHelper", "[registerEditCoverNewLauncher] host:" + Reflection.getOrCreateKotlinClass(r3.getClass()).getSimpleName() + '_' + r3.hashCode());
        final ActivityResultLauncher r5 = r3.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new k(r3, r4));
        return r3.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new l(r3, r5));
    }

    public static final Object c(MusicInfoEditHelper r4, String r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof MusicInfoEditHelper$inquireIsMessageEnd$1) == false) goto L7;
        MusicInfoEditHelper$inquireIsMessageEnd$1 r0 = (MusicInfoEditHelper$inquireIsMessageEnd$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        Message r9 = (Message) r7;
        if (r9 != null) goto L20;
    L22:
        r3 = false;
    L24:
        return Boxing.boxBoolean(r3);
    L20:
        if (com.larus.bmhome.chat.bean.d.j0(r9) != true) goto L22;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        IChatRepoService r10 = RepoDispatcherDelegate.b.e();
        r0.label = 1;
        r7 = r10.E1(r5, r0);
        if (r7 != r8) goto L17;
        return r8;
    L7:
        r0 = new MusicInfoEditHelper$inquireIsMessageEnd$1(r4, r6);
        goto L8
    }

    public static void d(Uri r4, Fragment r5, ActivityResultLauncher r6) {
        if (r4 == null) goto L5;
        FLogger.a.i("MusicInfoEditHelper", "[onActivityResult] called, icon_uri:" + r4);
        Uri r0 = Uri.fromFile(new PolarisFileWrapper(r5.requireActivity().getCacheDir(), "crop_image_cache.jpg"));
        Intent r1 = new Intent();
        Bundle r2 = new Bundle();
        r2.putParcelable("com.yalantis.ucrop.InputUri", r4);
        r2.putParcelable("com.yalantis.ucrop.OutputUri", r0);
        r2.putFloat("com.yalantis.ucrop.AspectRatioX", 1.0f);
        r2.putFloat("com.yalantis.ucrop.AspectRatioY", 1.0f);
        r1.setClass(r5.requireActivity(), UCropActivity.class);
        r1.putExtras(r2);
        r6.launch(r1);
        Unit r7 = Unit.INSTANCE;
        return;
    }

    public static void g(Fragment r8, Intent r9, a r10) {
        if (r9 == null) goto L5;
        Uri r11 = (Uri) r9.getParcelableExtra("com.yalantis.ucrop.OutputUri");
    L6:
        if (r11 == null) goto L8;
        r10.a(v.b.a);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8.getViewLifecycleOwner()), Dispatchers.getIO().plus(kr8.t.a), null, new MusicInfoEditHelper$launchImageUploader$1(r11, r8, r10, null), 2, null);
        FLogger.a.i("MusicInfoEditHelper", "[onActivityResult] success");
        return;
    L8:
        r10.a(new v.a(""));
        return;
    L5:
        r11 = null;
        goto L6
    }

    public static void e(Fragment r11, ActivityResultLauncher r12, ActivityResultLauncher r13, a r14) {
        Intrinsics.checkNotNullParameter(r11, "host");
        Intrinsics.checkNotNullParameter(r12, "editCoverLauncher");
        Intrinsics.checkNotNullParameter(r13, "editCoverNewLauncher");
        Intrinsics.checkNotNullParameter(r14, "callback");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11), null, null, new MusicInfoEditHelper$launchEditMusicCover$1$1(r14, r11, r11, r13, r12, null), 3, null);
    }

    public static void f(FragmentActivity r10, a r11, boolean r12, kr8.o r13) {
        Intrinsics.checkNotNullParameter(r10, "host");
        Intrinsics.checkNotNullParameter(r11, "callback");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10), null, null, new MusicInfoEditHelper$launchEditMusicName$1(r11, r10, r12, r13, null), 3, null);
    }

    public static final Object a(MusicInfoEditHelper r18, Fragment r19, Image r20, a r21, Continuation r22) {
        Image r0 = r20;
        r18.getClass();
        if ((r22 instanceof MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$1) == false) goto L7;
        MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$1 r2 = (MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$1) r22;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$1 r10 = r2;
        Object r1 = r10.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r10.label;
        String r14 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        MusicCreationContent r6 = (MusicCreationContent) r10.L$4;
        String r7 = (String) r10.L$3;
        a r8 = (a) r10.L$2;
        Image r9 = (Image) r10.L$1;
        Fragment r11 = (Fragment) r10.L$0;
        ResultKt.throwOnFailure(r1);
        MusicCreationContent r15 = r6;
        r0 = r9;
    L21:
        dm9.a.b r12 = (dm9.a) r1;
        if ((r12 instanceof dm9.a.b) == false) goto L34;
        dm9.a.b r13 = r12;
        if (r13.a.isSuccess() == false) goto L26;
        FLogger.a.i("MusicInfoEditHelper", "[callUpdateBigMusicMessageApiUnify] success, messageId:" + r7 + ", image:" + r0.key);
        r8.a(v.c.a);
        kr8.l.a.b(new kr8.f("music_detail", r15.getVid(), "popup_click", 1), null, 3);
    L42:
        return Unit.INSTANCE;
    L26:
        FLogger.a.e("MusicInfoEditHelper", "[callUpdateBigMusicMessageApiUnify] error, messageId:" + r7 + ", code:" + r13.a.getCode() + ", msg:" + r13.a.getMsg());
        String r16 = r13.a.getMsg();
        if (r16 != null) goto L32;
        StringBuilder r17 = new StringBuilder();
        Context r23 = r11.getContext();
        if (r23 == null) goto L31;
        r14 = r23.getString(2131907942);
    L31:
        r17.append(r14);
        r17.append(" code: ");
        r17.append(r13.a.getCode());
        r16 = r17.toString();
    L32:
        r8.a(new v.a(r16));
        goto L42
    L34:
        if ((r12 instanceof dm9.a.a) == false) goto L42;
        FLogger.a.e("MusicInfoEditHelper", "[callUpdateBigMusicMessageApiUnify] exception, messageId:" + r7 + ", " + ((dm9.a.a) r12).c);
        Context r24 = r11.getContext();
        if (r24 == null) goto L39;
        String r25 = r24.getString(2131907942);
        if (r25 == null) goto L39;
    L40:
        r8.a(new v.a(r25));
    L39:
        r25 = "";
        goto L40
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        String r26 = r21.c().a;
        r15 = r21.c().c;
        if (r15 != null) goto L17;
        FLogger.a.e("MusicInfoEditHelper", "[callUpdateBigMusicMessageApiUnify] musicContent is null");
        return Unit.INSTANCE;
    L17:
        UpdateBigMusicMessageApi.a r27 = UpdateBigMusicMessageApi.a;
        MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$result$1 r28 = new MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$result$1(r26, r0, r15, null);
        r10.L$0 = r19;
        r10.L$1 = r0;
        r10.L$2 = r21;
        r10.L$3 = r26;
        r10.L$4 = r15;
        r10.label = 1;
        r27.getClass();
        FlowHttpConnection r29 = FlowHttpConnection.a;
        Object r30 = FlowHttpConnection.g("Social", UpdateBigMusicMessageApi.class, r28, false, null, null, null, r10, 248);
        if (r30 == r4) goto L44;
        r11 = r19;
        r7 = r26;
        r1 = r30;
        r8 = r21;
        goto L21
    L44:
        return r4;
    L7:
        r2 = new MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$1(r18, r22);
        goto L8
    }

    public static final Object b(MusicInfoEditHelper r5, Fragment r6, Image r7, a r8, Continuation r9) {
        r5.getClass();
        if ((r9 instanceof MusicInfoEditHelper$editCreationCover$1) == false) goto L7;
        MusicInfoEditHelper$editCreationCover$1 r0 = (MusicInfoEditHelper$editCreationCover$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        String r3 = "";
        ModifiedUserCreationMusic r4 = null;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r8 = (a) r0.L$1;
        r6 = (Fragment) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L23:
        Pair r12 = (Pair) r10;
        if (r12 == null) goto L26;
        ModifiedUserCreationResponse r13 = (ModifiedUserCreationResponse) r12.getFirst();
    L27:
        if (r13 == null) goto L33;
        ModifiedUserCreationContent r14 = r13.b;
        if (r14 == null) goto L33;
        ModifiedUserCreationMusic r15 = r14.a;
        if (r15 == null) goto L33;
        ImageInfo r16 = r15.b;
    L34:
        if (r16 == null) goto L41;
        r8.a(v.c.a);
        if (r13 == null) goto L40;
        ModifiedUserCreationContent r17 = r13.b;
        if (r17 == null) goto L40;
        r4 = r17.a;
    L40:
        r8.b(r4);
    L49:
        return Unit.INSTANCE;
    L41:
        Context r18 = r6.getContext();
        if (r18 == null) goto L47;
        String r19 = r18.getString(2131907942);
        if (r19 == null) goto L47;
        r3 = r19;
    L47:
        r8.a(new v.a(r3));
    L33:
        r16 = null;
        goto L34
    L26:
        r13 = null;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        String r20 = r8.c().b;
        if (r8.c().c != null) goto L17;
        FLogger.a.e("MusicInfoEditHelper", "[callUpdateBigMusicMessageApiUnify] musicContent is null");
        return Unit.INSTANCE;
    L17:
        e0 r21 = e0.a;
        if (r20 != null) goto L20;
        r20 = "";
    L20:
        String r22 = r7.key;
        r0.L$0 = r6;
        r0.L$1 = r8;
        r0.label = 1;
        r10 = r21.k(r20, null, r22, r0);
        if (r10 != r11) goto L23;
        return r11;
    L7:
        r0 = new MusicInfoEditHelper$editCreationCover$1(r5, r9);
        goto L8
    }
}
