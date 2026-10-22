package com.larus.app.share;

import android.content.Context;
import android.widget.ImageView;
import aza.d;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.share.impl.view.j0;
import com.larus.share.impl.view.k0;
import com.larus.share.service.IShareDoubaoForwardService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardDoubaoContent;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mpc.f;
import mpc.g;
import xp9.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00070\t26\u0010\f\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\rH\u0016J0\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J<\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\n2\u0006\u0010\u001f\u001a\u00020\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0016J6\u0010'\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010)\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u000bH\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010,\u001a\u0004\u0018\u00010-H\u0002J\f\u0010.\u001a\u00020\u000b*\u00020/H\u0002J\f\u00100\u001a\u00020/*\u00020\u000bH\u0002J\f\u00101\u001a\u000202*\u00020&H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u00103\u001a\u000204H\u0002J\f\u00105\u001a\u00020$*\u00020&H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/app/share/ShareDoubaoForwardService;", "Lcom/larus/share/service/IShareDoubaoForwardService;", "<init>", "()V", "forwardApi", "Lcom/suite/lark/platform/feature/forward/doubao/api/IForwardDoubaoApi;", "requestRecentForwardList", "", "onSuccess", "Lkotlin/Function1;", "", "Lcom/larus/share/bean/DoubaoForwardTarget;", "onFailure", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errorCode", "", "errorMessage", "loadAvatar", "context", "Landroid/content/Context;", "avatarView", "Landroid/widget/ImageView;", "target", "width", "height", "send", "doubaoMsgIds", "", "textContent", "targetInfos", "callback", "Lcom/larus/share/service/IShareDoubaoForwardService$SendCallback;", "openFileForwardPicker", "", "file", "Lcom/larus/bmhome/share/panel/HostForwardFileContent;", "sendFile", "note", "openForwardTarget", "targetInfo", "getForwardApi", "getImUserService", "Lcom/ss/android/lark/biz/officesdk/im/IIMUserService;", "toTarget", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoInfo;", "toForwardInfo", "toForwardRequest", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoFileForwardRequest;", "throwable", "", "isValid", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ShareDoubaoForwardService implements IShareDoubaoForwardService {
    public static final /* synthetic */ int b = 0;
    public f a;

    public static final class a {
    }

    public static final class b implements g {
        public final /* synthetic */ Function1<List<kw9.a>, Unit> a;
        public final /* synthetic */ ShareDoubaoForwardService b;
        public final /* synthetic */ Function2<Integer, String, Unit> c;

        public final void onSuccess(List<npc.c> r13) {
            Intrinsics.checkNotNullParameter(r13, "list");
            Function1<List<kw9.a>, Unit> r0 = this.a;
            List<npc.c> r14 = r13;
            ShareDoubaoForwardService r1 = this.b;
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator<T> r15 = r14.iterator();
        L4:
            if (r15.hasNext() == false) goto L16;
            npc.c r3 = (npc.c) r15.next();
            int r4 = ShareDoubaoForwardService.b;
            r1.getClass();
            String r6 = r3.a;
            String r7 = r3.c;
            String r8 = r3.b;
            String r9 = r3.d;
            String r10 = r3.f;
            int r5 = r3.e;
            if (r5 != 1) goto L8;
            int r11 = 1;
        L15:
            r2.add(new kw9.a(r6, r7, r8, r9, r10, r11));
            goto L4
        L8:
            if (r5 != 2) goto L10;
            r11 = 2;
            goto L15
        L10:
            if (r5 == 3) goto L12;
            r11 = 0;
            goto L15
        L12:
            r11 = 3;
            goto L15
        L16:
            r0.invoke(r2);
        }

        public final void onFailure(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "errorMessage");
            this.c.invoke(Integer.valueOf(r2), r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super List<kw9.a>, Unit> r1, ShareDoubaoForwardService r2, Function2<? super Integer, ? super String, Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements g {
        public c() {
        }

        public final void onFailure(int r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "errorMessage");
        }

        public final void onSuccess(List<npc.c> r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
        }
    }

    static {
    }

    public ShareDoubaoForwardService() {
    }

    public final void d() {
    }

    public final f h() {
        f r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Object r1 = o.a;
        Object r2 = o.a;
        if ((r2 instanceof OfficeSDKUserApi) == false) goto L8;
        OfficeSDKUserApi r3 = (OfficeSDKUserApi) r2;
    L9:
        if (r3 == null) goto L14;
        f r4 = r3.getService(f.class);
        if (r4 == null) goto L15;
        this.a = r4;
        return r4;
    L15:
        return null;
    L14:
        return null;
    L8:
        r3 = null;
        goto L9
    }

    public static npc.c i(kw9.a r3) {
        npc.c r0 = new npc.c();
        String r1 = r3.a;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.a = r1;
        String r2 = r3.c;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.b = r2;
        String r4 = r3.b;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.c = r4;
        String r5 = r3.d;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.d = r5;
        String r6 = r3.e;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r0.f = r6;
        int r7 = r3.f;
        int r8 = 1;
        if (r7 == 1) goto L9;
        r8 = 2;
        if (r7 == 2) goto L9;
        r8 = 3;
        if (r7 == 3) goto L9;
        r8 = 0;
    L9:
        r0.e = r8;
        return r0;
    }

    public final boolean e(Context r8, kw9.a r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "targetInfo");
        LarkSocialExp.a.getClass();
        boolean r2 = false;
        if (LarkSocialExp.e() == true) goto L6;
        FLogger.a.w("ShareDoubaoForwardService", "skip open forward target: IM runtime is not ready");
        return false;
    L6:
        Object r0 = o.a;
        String r4 = null;
        if ((r0 instanceof OfficeSDKUserApi) == false) goto L9;
        OfficeSDKUserApi r1 = (OfficeSDKUserApi) r0;
    L10:
        if (r1 == null) goto L12;
        d r3 = (d) r1.getService(d.class);
    L13:
        if (r3 != null) goto L48;
        return false;
    L48:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L40
        if (r9.f != 3) goto L27;
        String r6 = r9.d;     // Catch: Throwable -> L40
        if ((!StringsKt.isBlank(r6)) == false) goto L20;
        r4 = r6;
    L20:
        if (r4 != null) goto L23;
        r4 = r9.a;     // Catch: Throwable -> L40
    L23:
        if (StringsKt.isBlank(r4) == true) goto L38;
        r3.P().b(r8, r4);     // Catch: Throwable -> L40
    L37:
        r2 = true;
    L38:
        Object r10 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L40
    L42:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L47;
        FLogger.a.e("ShareDoubaoForwardService", "open forward target failed", r11);
        r10 = Boolean.FALSE;
    L47:
        return ((Boolean) r10).booleanValue();
    L27:
        if ((!StringsKt.isBlank(r9.e)) == false) goto L30;
        String r12 = r9.e;     // Catch: Throwable -> L40
    L34:
        if (StringsKt.isBlank(r12) == true) goto L38;
        r3.P().a(r8, r12);     // Catch: Throwable -> L40
        goto L37
    L30:
        if (r9.f != 2) goto L32;
        r12 = r9.a;     // Catch: Throwable -> L40
        goto L34
    L32:
        r12 = "";
    L40:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L12:
        r3 = null;
        goto L13
    L9:
        r1 = null;
        goto L10
    }

    public final boolean f(Context r10, com.larus.bmhome.share.panel.c r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "file");
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.e() == false) goto L29;
        boolean r2 = true;
        if ((!StringsKt.isBlank(r11.a)) == true) goto L7;
    L11:
        r2 = false;
    L12:
        if (r2 == false) goto L29;
        f r0 = h();
        if (r0 != null) goto L30;
        return false;
    L30:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
        Object r12 = Result.constructor-impl(Boolean.valueOf(r0.i1(r10, new npc.a(r11.a, r11.b, r11.c, r11.d, r11.e))));     // Catch: Throwable -> L19
    L21:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L24;
        FLogger.a.e("ShareDoubaoForwardService", "open host file forward picker failed", r13);
    L24:
        Boolean r14 = Boolean.FALSE;
        if (Result.isFailure-impl(r12) == false) goto L28;
        r12 = r14;
    L28:
        return ((Boolean) r12).booleanValue();
    L19:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L7:
        if ((!StringsKt.isBlank(r11.b)) == false) goto L11;
        if (r11.c <= 0) goto L11;
    L29:
        return false;
    }

    public final void g(final Function1<? super List<kw9.a>, Unit> r5, final Function2<? super Integer, ? super String, Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "onSuccess");
        Intrinsics.checkNotNullParameter(r6, "onFailure");
        f r0 = h();
        if (r0 != null) goto L24;
        o.b(new u48.a(this, r5, r6));
        return;
    L24:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        r0.cc(ForwardScene.CHAT, new b(r5, this, r6), true);     // Catch: Throwable -> L8
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L26;
        FLogger.a.e("ShareDoubaoForwardService", "request cached recent forward list failed", r8);
        String r3 = r8.getMessage();
        if (r3 != null) goto L15;
        r3 = r8.getClass().getSimpleName();
    L15:
        r6.invoke(-1, r3);
    L26:
        r0.cc(ForwardScene.CHAT, new c(), false);     // Catch: Throwable -> L18
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L28;
        FLogger.a.e("ShareDoubaoForwardService", "refresh recent forward list failed", r10);
        return;
    L28:
        return;
    L18:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void a(Context r9, ImageView r10, kw9.a r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "avatarView");
        Intrinsics.checkNotNullParameter(r11, "target");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        f r1 = h();     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.g8(r9, r10, r11.c, r11.a, r12, r13);     // Catch: Throwable -> L9
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L9
    L11:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L17;
        FLogger.a.e("ShareDoubaoForwardService", "load forward target avatar failed", r16);
        return;
    L17:
        return;
    L6:
        r14 = null;
    L9:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void b(Context r6, List r7, String r8, List r9, j0 r10) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "doubaoMsgIds");
        Intrinsics.checkNotNullParameter(r8, "textContent");
        Intrinsics.checkNotNullParameter(r9, "targetInfos");
        Intrinsics.checkNotNullParameter(r10, "callback");
        f r0 = h();
        if (r0 != null) goto L6;
        r10.onFailure(null, null);
        return;
    L6:
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r11 = r9.iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        kw9.a r3 = (kw9.a) r11.next();
        if (r3.f != 0) goto L12;
        r3 = kw9.a.a(r3);
    L12:
        r1.add(r3);
        goto L8
    L13:
        ForwardDoubaoContent r12 = new ForwardDoubaoContent();
        r12.setDoubaoMsgIds(r7);
        if ((!StringsKt.isBlank(r8)) == false) goto L31;
        r12.setTextContent(r8);
    L31:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L22
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));     // Catch: Throwable -> L22
        Iterator r15 = r1.iterator();     // Catch: Throwable -> L22
    L18:
        if (r15.hasNext() == false) goto L20;
        r14.add(i((kw9.a) r15.next()));     // Catch: Throwable -> L22
        goto L18
    L20:
        r0.gf(r6, r12, r14, new u48.b(r10, r1));     // Catch: Throwable -> L22
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L37;
        FLogger.a.e("ShareDoubaoForwardService", "send doubao messages to host failed", r17);
        String r19 = r17.getMessage();
        if (r19 != null) goto L29;
        r19 = r17.getClass().getSimpleName();
    L29:
        r10.onFailure(-1, r19);
        return;
    L37:
        return;
    L22:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }

    public final boolean c(Context r11, com.larus.bmhome.share.panel.c r12, String r13, List r14, k0 r15) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "file");
        Intrinsics.checkNotNullParameter(r13, "note");
        Intrinsics.checkNotNullParameter(r14, "targetInfos");
        Intrinsics.checkNotNullParameter(r15, "callback");
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.e() == false) goto L42;
        boolean r2 = true;
        if ((!StringsKt.isBlank(r12.a)) == true) goto L7;
    L11:
        r2 = false;
    L12:
        if (r2 == false) goto L42;
        if (((ArrayList) r14).isEmpty() == true) goto L42;
        f r3 = h();
        if (r3 != null) goto L19;
        return false;
    L19:
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L21:
        if (r16.hasNext() == false) goto L43;
        kw9.a r4 = (kw9.a) r16.next();
        if (r4.f != 0) goto L25;
        r4 = kw9.a.a(r4);
    L25:
        r0.add(r4);
        goto L21
    L43:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L32
        npc.a r19 = new npc.a(r12.a, r12.b, r12.c, r12.d, r12.e);     // Catch: Throwable -> L32
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));     // Catch: Throwable -> L32
        Iterator r110 = r0.iterator();     // Catch: Throwable -> L32
    L28:
        if (r110.hasNext() == false) goto L30;
        r5.add(i((kw9.a) r110.next()));     // Catch: Throwable -> L32
        goto L28
    L30:
        Object r111 = Result.constructor-impl(Boolean.valueOf(r3.g1(r11, r19, r5, r13, new u48.c(r15, r0))));     // Catch: Throwable -> L32
    L34:
        Throwable r112 = Result.exceptionOrNull-impl(r111);
        if (r112 == null) goto L37;
        FLogger.a.e("ShareDoubaoForwardService", "send host file failed before request", r112);
    L37:
        Boolean r113 = Boolean.FALSE;
        if (Result.isFailure-impl(r111) == false) goto L41;
        r111 = r113;
    L41:
        return ((Boolean) r111).booleanValue();
    L32:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L7:
        if ((!StringsKt.isBlank(r12.b)) == false) goto L11;
        if (r12.c <= 0) goto L11;
    L42:
        return false;
    }
}
