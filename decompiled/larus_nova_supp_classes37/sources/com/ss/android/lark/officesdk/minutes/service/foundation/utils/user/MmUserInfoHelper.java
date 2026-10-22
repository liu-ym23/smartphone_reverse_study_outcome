package com.ss.android.lark.officesdk.minutes.service.foundation.utils.user;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmParticipantType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmSubtitleSpeakerType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i;
import com.ss.android.lark.pb.minutes.v1.MinutesChatter;
import com.ss.android.lark.pb.minutes.v1.MinutesMgetChattersResponse;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmUserInfoHelper implements a {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final String b;
    public final ConcurrentHashMap<String, i> c;
    public final LruCache<String, String> d;

    public MmUserInfoHelper(MinutesUCCImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        this.a = r2;
        this.b = "MmUserInfoHelper";
        this.c = new ConcurrentHashMap();
        this.d = new LruCache(100);
    }

    public final i f(i r10) {
        Intrinsics.checkNotNullParameter(r10, MmEndWindowAvatar.TYPE_SPEAKER);
        boolean r1 = false;
        if (r10.f.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r10;
    L8:
        i r3 = this.c.get(r10.a);
        if (r3 != null) goto L12;
        return null;
    L12:
        if (r3.f.length() != 0) goto L14;
        r1 = true;
    L14:
        if (r1 == false) goto L17;
        return null;
    L17:
        return i.a(r3, MmParticipantType.LARK_USER, MmSubtitleSpeakerType.VOICE_PRINT_SPEAKER, null, null, 115);
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a
    public final void a(LKUIRoundedImageView r3, c r4) {
        Intrinsics.checkNotNullParameter(r3, "imageView");
        Intrinsics.checkNotNullParameter(r4, "config");
        if (r4.b > 0) goto L5;
    L22:
        lvb.a.b(this.b, "loadAvatarViewWithUrl skip, invalid size: " + r4.b + 'x' + r4.c);
        return;
    L5:
        if (r4.c <= 0) goto L22;
        if (r4.a.length() != 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L14;
        lvb.a.b(this.b, "loadAvatarViewWithUrl skip, url is empty");
        return;
    L14:
        RequestBuilder r1 = Glide.with(r3.getContext()).load(r4.a).centerCrop();
        int r2 = r4.e;
        if (r2 == 0) goto L17;
        r1 = (RequestBuilder) r1.error(r2);
    L17:
        int r5 = r4.d;
        if (r5 == 0) goto L20;
        r1 = r1.placeholder(r5);
    L20:
        r1.override(r4.b, r4.c).into(r3);
        return;
    L10:
        r0 = false;
        goto L11
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a
    public final void b(LKUIRoundedImageView r8, b r9) {
        Intrinsics.checkNotNullParameter(r8, "imageView");
        Intrinsics.checkNotNullParameter(r9, "config");
        if (r9.c > 0) goto L5;
    L9:
        lvb.a.b(this.b, "loadAvatarViewWithKey skip, invalid size: " + r9.c + 'x' + r9.d);
        return;
    L5:
        if (r9.d <= 0) goto L9;
        BuildersKt.launch$default(this.a.B(), null, null, new MmUserInfoHelper$loadAvatarViewWithKey$1(this, r9, r8, null), 3, null);
    }

    public final Object d(b r16, Continuation<? super Bitmap> r17) {
        if ((r17 instanceof MmUserInfoHelper$getAvatarWithKey$1) == false) goto L7;
        MmUserInfoHelper$getAvatarWithKey$1 r1 = (MmUserInfoHelper$getAvatarWithKey$1) r17;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MmUserInfoHelper$getAvatarWithKey$1 r8 = r1;
        Object r0 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        boolean r11 = true;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L46:
        return r0;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r4 = (String) r8.L$1;
        b r5 = (b) r8.L$0;
        ResultKt.throwOnFailure(r0);
        Object r6 = ((Result) r0).unbox-impl();
    L28:
        if (Result.isFailure-impl(r6) == false) goto L30;
        r6 = null;
    L30:
        String r7 = (String) r6;
        if (r7 == null) goto L33;
        this.d.put(r4, r7);
    L35:
        if (r7 != null) goto L37;
    L40:
        if (r11 == false) goto L43;
        lvb.a.b(this.b, "entityId:" + r5.b + ", avatarKey: " + r5.a + ", avatarPath is empty ");
        return null;
    L43:
        CoroutineDispatcher r10 = Dispatchers.getIO();
        MmUserInfoHelper$getAvatarWithKey$2 r12 = new MmUserInfoHelper$getAvatarWithKey$2(r7, r5, this, null);
        r8.L$0 = null;
        r8.L$1 = null;
        r8.label = 2;
        r0 = BuildersKt.withContext(r10, r12, r8);
        if (r0 != r9) goto L46;
        return r9;
    L37:
        if (r7.length() == 0) goto L40;
        r11 = false;
        goto L40
    L33:
        r7 = null;
        goto L35
    L16:
        ResultKt.throwOnFailure(r0);
        if (r16.c > 0) goto L19;
    L47:
        lvb.a.b(this.b, "getAvatarWithKey skip, invalid size: " + r16.c + 'x' + r16.d);
        return null;
    L19:
        if (r16.d <= 0) goto L47;
        Resources r13 = UIHelper.getResources();
        float r14 = WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics()).density;
        int r15 = (int) Math.max(r16.c, r16.d);
        String r18 = r16.b + '_' + r16.a + '_' + r16.c + 'x' + r16.d;
        lvb.a.e(this.b, "pathKey --> " + r18);
        r7 = this.d.get(r18);
        if (r7 != null) goto L34;
        String r19 = r16.b;
        String r20 = r16.a;
        r8.L$0 = r16;
        r8.L$1 = r18;
        r8.label = 1;
        r6 = g(r19, r20, r15, r14, r8);
        if (r6 != r9) goto L26;
        return r9;
    L26:
        r5 = r16;
        r4 = r18;
        goto L28
    L34:
        r5 = r16;
    L7:
        r1 = new MmUserInfoHelper$getAvatarWithKey$1(this, r17);
        goto L8
    }

    public final Object e(c r4, Continuation<? super Bitmap> r5) {
        if (r4.b > 0) goto L5;
    L16:
        lvb.a.b(this.b, "getAvatarWithUrl skip, invalid size: " + r4.b + 'x' + r4.c);
        return null;
    L5:
        if (r4.c <= 0) goto L16;
        if (r4.a.length() != 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L15;
        lvb.a.b(this.b, "getAvatarWithUrl skip, url is empty");
        return null;
    L15:
        return BuildersKt.withContext(Dispatchers.getIO(), new MmUserInfoHelper$getAvatarWithUrl$2(r4, this, null), r5);
    L10:
        r0 = false;
        goto L11
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a
    public final Object c(String r12, i r13, Continuation<? super Result<i>> r14) {
        if ((r14 instanceof MmUserInfoHelper$getUserInfo$1) == false) goto L7;
        MmUserInfoHelper$getUserInfo$1 r0 = (MmUserInfoHelper$getUserInfo$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        r13 = (i) r0.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
        Object r16 = ((Result) r15).unbox-impl();     // Catch: Throwable -> L14
    L52:
        if (Result.isFailure-impl(r16) == false) goto L54;
        Object r5 = null;
    L55:
        MinutesMgetChattersResponse r6 = (MinutesMgetChattersResponse) r5;     // Catch: Throwable -> L14
        if (Result.isSuccess-impl(r16) == false) goto L69;
        if (r6 == null) goto L69;
        MinutesChatter r17 = (MinutesChatter) CollectionsKt.firstOrNull(r6.chatters);     // Catch: Throwable -> L14
        if (r17 == null) goto L67;
        String r18 = r17.name;     // Catch: Throwable -> L14
        if (r18.length() != 0) goto L63;
        r4 = true;
    L63:
        if (r4 == false) goto L65;
        r18 = "";
    L65:
        String r8 = r18;
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L14
        i r19 = i.a(r13, null, null, r8, r17.avatar_key, 31);     // Catch: Throwable -> L14
        this.c.put(r13.a, r19);     // Catch: Throwable -> L14
        return Result.constructor-impl(r19);
    L67:
        lvb.a.b(this.b, "getUserInfo failed empty user info");     // Catch: Throwable -> L14
        return Result.constructor-impl(ResultKt.createFailure(new Exception("empty user info")));
    L69:
        lvb.a.b(this.b, "getUserInfo failed or empty result exception:" + Result.exceptionOrNull-impl(r16));     // Catch: Throwable -> L14
        Throwable r110 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L14
        if (r110 != null) goto L73;
        r110 = new Exception("unknown error");     // Catch: Throwable -> L14
    L73:
        return Result.constructor-impl(ResultKt.createFailure(r110));
    L54:
        r5 = r16;
        goto L55
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        if (r13.f.length() <= 0) goto L21;
        boolean r111 = true;
    L22:
        if (r111 == true) goto L24;
    L30:
        i r7 = this.c.get(r13.a);
        if (r7 == null) goto L45;
        if (r7.f.length() <= 0) goto L35;
        boolean r112 = true;
    L36:
        if (r112 == false) goto L45;
        if (r7.g.length() <= 0) goto L40;
        boolean r113 = true;
    L41:
        if (r113 == false) goto L45;
        Result.Companion r114 = Result.Companion;
        return Result.constructor-impl(i.a(r7, MmParticipantType.LARK_USER, MmSubtitleSpeakerType.VOICE_PRINT_SPEAKER, null, null, 115));
    L40:
        r113 = false;
        goto L41
    L35:
        r112 = false;
    L45:
        if (r13.d.isLarkUser() == false) goto L47;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L14
        MmRecordingNetHelper r116 = this.a.G();     // Catch: Throwable -> L14
        List r9 = CollectionsKt.listOf(r13.a);     // Catch: Throwable -> L14
        r0.L$0 = r13;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        r16 = r116.t(r9, r0);     // Catch: Throwable -> L14
        if (r16 != r2) goto L52;
        return r2;
    L47:
        return Result.constructor-impl(r13);
    L24:
        if (r13.g.length() <= 0) goto L26;
        boolean r117 = true;
    L27:
        if (r117 == false) goto L30;
        this.c.put(r13.a, r13);
        return Result.constructor-impl(r13);
    L26:
        r117 = false;
        goto L27
    L21:
        r111 = false;
    L14:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new MmUserInfoHelper$getUserInfo$1(this, r14);
        goto L8
    }

    public final Object g(String r11, String r12, int r13, float r14, Continuation<? super Result<String>> r15) {
        if ((r15 instanceof MmUserInfoHelper$syncGetAvatarPath$1) == false) goto L7;
        MmUserInfoHelper$syncGetAvatarPath$1 r0 = (MmUserInfoHelper$syncGetAvatarPath$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L18:
        return ((Result) r16).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        ExecutorCoroutineDispatcher r17 = MMCoroutines.a();
        MmUserInfoHelper$syncGetAvatarPath$2 r4 = new MmUserInfoHelper$syncGetAvatarPath$2(r11, r12, r13, r14, null);
        r0.label = 1;
        r16 = BuildersKt.withContext(r17, r4, r0);
        if (r16 != r2) goto L18;
        return r2;
    L7:
        r0 = new MmUserInfoHelper$syncGetAvatarPath$1(this, r15);
        goto L8
    }
}
