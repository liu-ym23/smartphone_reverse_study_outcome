package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.api.utils.h;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.context.AnchorMiniAppContext;
import com.bytedance.android.live.openplatform.impl.miniappcommon.debug.MiniAppDebugContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.launch.LaunchContextService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.message.model.wc;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0007\b\tB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/debug/MiniAppAnchorDebugContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/debug/MiniAppDebugContextService;", "Lcom/bytedance/android/live/broadcastgame/api/opengame/qrcode/IQRCodeService$b;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "b", "c", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppAnchorDebugContextService extends MiniAppDebugContextService implements IQRCodeService.b {
    public static final /* synthetic */ int f = 0;
    public Disposable c;
    public boolean d;
    public OpenPlatformDebugFloatBall e;

    public static final class a {
    }

    public interface b {
        void onError(Throwable r1);

        void onSuccess(String r1);
    }

    public final class c extends ro0.b<wc> {
        public final MessageType d;
        public final /* synthetic */ MiniAppAnchorDebugContextService e;

        @Override // ro0.b
        public final MessageType a() {
            return this.d;
        }

        public c(MiniAppAnchorDebugContextService r2) {
            this.e = r2;
            int r0 = MiniAppAnchorDebugContextService.f;
            super(r2.getOpenPlatformContext());
            this.d = MessageType.INTERACT_OPEN_DEVELOP_MESSAGE;
        }

        /* JADX WARN: Type inference failed for: r3v5, types: [android.view.View, com.bytedance.android.live.openplatform.impl.miniappanchor.debug.OpenPlatformDebugFloatBall] */
        @Override // ro0.b
        public final void b(tlc.d r11) {
            wc r12 = (wc) r11;
            Intrinsics.checkNotNullParameter(r12, MultiLinkOpenSource.MESSAGE);
            int r0 = qo0.a.a;
            qo0.a.a("MiniAppAnchorDebugContextService", "收到调试 IM：\n" + r12);
            MiniAppAnchorDebugContextService r1 = this.e;
            r1.d = true;
            Disposable r2 = r1.c;
            if (r2 == null) goto L5;
            r2.dispose();
        L5:
            MiniAppAnchorDebugContextService r3 = this.e;
            r12.getClass();
            r3.getClass();
            if (this.e.f(this.b.getRoomId(), this.e.b, r12.G(), r12.H(), r12.E()) == false) goto L16;
            MiniAppAnchorDebugContextService r13 = this.e;
            r13.getClass();
            int r4 = OpenPlatformDebugFloatBall.b;
            Context r5 = r13.getOpenPlatformContext().getContext();
            OpenPlatformContext r6 = r13.getOpenPlatformContext();
            if (r6 == null) goto L15;
            ViewGroup r7 = ((AnchorMiniAppContext) r6).getContainerView();
            if (r7 == null) goto L13;
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r7, "rootView");
            Intrinsics.checkNotNullParameter(r13, "listener");
            ?? r8 = new OpenPlatformDebugFloatBall(r7, r5, r13);
            UtilityKotlinExtentionsKt.w(r8);
            Unit r9 = Unit.INSTANCE;
            r13.e = r8;
            qo0.a.a("MiniAppAnchorDebugContextService", "执行 createDebugFloatBall()，显示调试悬浮球");
        L13:
            this.e.k();
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.miniappanchor.context.AnchorMiniAppContext");
        L16:
            UtilityKotlinExtentionsKt.s(0, false, false, MiniAppAnchorDebugContextService$OpenDevelopMessageListener$onReceiveMessage$1.INSTANCE, 7);
        }
    }

    public static final class d implements b {
        public final /* synthetic */ MiniAppAnchorDebugContextService a;

        public d(MiniAppAnchorDebugContextService r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.debug.MiniAppAnchorDebugContextService.b
        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
            f2.c(s1.B(2131920848), 0);
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.debug.MiniAppAnchorDebugContextService.b
        public final void onSuccess(String r10) {
            Intrinsics.checkNotNullParameter(r10, "httpsLink");
            int r0 = qo0.a.a;
            qo0.a.a("MiniAppAnchorDebugContextService", "访问短链，重定向后的 url : " + r10);
            MiniAppAnchorDebugContextService r1 = this.a;
            int r2 = MiniAppAnchorDebugContextService.f;
            r1.getClass();
            boolean r3 = false;
            if (r10.length() != 0) goto L5;
            boolean r4 = true;
        L7:
            if (r4 == true) goto L27;
            String r5 = UriProtector.parse(r10).getEncodedQuery();
            if (r5 != null) goto L12;
        L15:
            boolean r7 = true;
        L16:
            if (r7 == true) goto L27;
            String r11 = UriProtector.getQueryParameter(UriProtector.parse(r10), "tech_type");
            if (r11 == null) goto L21;
            Integer r12 = Integer.valueOf(CastIntegerProtector.parseInt(r11));
        L22:
            if (r12 == null) goto L27;
            if (r12.intValue() != 1) goto L27;
            String r13 = UriProtector.parse("snssdk" + k.n(IHostContext.class).appId() + "://live_open_platform?").buildUpon().appendQueryParameter("timor_schema", "snssdk" + k.n(IHostContext.class).appId() + "://microapp?" + r5).appendQueryParameter("enter_from", "IDE").appendQueryParameter("open_type", "developer_debug").build().toString();
        L28:
            qo0.a.a("MiniAppAnchorDebugContextService", "url 适配为长链后 : " + r13);
            MiniAppAnchorDebugContextService r6 = this.a;
            r6.getClass();
            if (r13.length() != 0) goto L31;
            boolean r8 = true;
        L32:
            if (r8 == true) goto L56;
            Uri r14 = UriProtector.parse(r13);
            String r9 = UriProtector.getQueryParameter(r14, "timor_schema");
            String r15 = UriProtector.getQueryParameter(r14, "open_type");
            String r16 = UriProtector.getQueryParameter(r14, "enter_from");
            if (r9 != null) goto L37;
        L40:
            boolean r17 = true;
        L41:
            if (r17 == true) goto L56;
            if (r15 != null) goto L44;
        L47:
            boolean r18 = true;
        L48:
            if (r18 == true) goto L56;
            if (r16 != null) goto L51;
        L52:
            r3 = true;
        L53:
            if (r3 == true) goto L56;
            int r19 = r6.i(r9);
        L57:
            r6.j(r19);
            qo0.a.a("MiniAppAnchorDebugContextService", "完成扫码校验，schema = " + this.a.a);
            return;
        L51:
            if (r16.length() != 0) goto L53;
        L44:
            if (r15.length() == 0) goto L47;
            r18 = false;
            goto L48
        L37:
            if (r9.length() == 0) goto L40;
            r17 = false;
        L56:
            r19 = 101;
            goto L57
        L31:
            r8 = false;
            goto L32
        L21:
            r12 = null;
            goto L22
        L12:
            if (r5.length() == 0) goto L15;
            r7 = false;
        L27:
            r13 = "";
            goto L28
        L5:
            r4 = false;
            goto L7
        }
    }

    static {
    }

    public final void k() {
        qo0.a.a("MiniAppAnchorDebugContextService", "执行 startDebug()");
        LaunchContextService.openMiniApp$default((LaunchContextService) getOpenPlatformContext().getService(LaunchContextService.class), this.a, new ko0.b(LaunchParamConstant$Scene.a, "scan", "anchor", null, null, null, null, null, null, false, false, null, 16376), null, 4, null);
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.c = null;
        AppCompatImageView r1 = this.e;
        if (r1 == null) goto L15;
        OpenPlatformContext r2 = getOpenPlatformContext();
        if (r2 == null) goto L14;
        ViewGroup r3 = ((AnchorMiniAppContext) r2).getContainerView();
        if (r3 == null) goto L12;
        r3.removeView(r1);
    L12:
        UtilityKotlinExtentionsKt.t(r1);
        goto L15
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.miniappanchor.context.AnchorMiniAppContext");
    L15:
        this.e = null;
    }

    public MiniAppAnchorDebugContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    public final boolean b(int r4) {
        f2.c(s1.B(2131920848), 0);
        int r0 = qo0.a.a;
        qo0.a.b("MiniAppAnchorDebugContextService", "", new Throwable("扫码错误，errorType = " + r4));
        return true;
    }

    public final boolean c(final String r5) {
        int r0 = qo0.a.a;
        qo0.a.a("MiniAppAnchorDebugContextService", "扫码结果 : " + r5);
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        f2.c(s1.B(2131920848), 0);
    L15:
        return false;
    L12:
        if (h.d(r5) == false) goto L14;
        j(i(r5));
        goto L15
    L14:
        final d r2 = new d(this);
        ThreadPoolHelper.c().execute(new MiniAppAnchorDebugContextService$getDeepLink$1(r5, r2));
        goto L15
    L5:
        if (r5.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final String h(String r9) {
        Intrinsics.checkNotNullParameter(r9, "schema");
        int r0 = qo0.a.a;
        qo0.a.a("MiniAppAnchorDebugContextService", "增加调试参数，原 schema ：".concat(r9));
        SchemaInfo.b r1 = SchemaInfo.s;
        r1.getClass();
        SchemaInfo r2 = SchemaInfo.b.b(r9);
        if (r2 != null) goto L5;
        return r9;
    L5:
        SchemaInfo.a r3 = new SchemaInfo.a(r9);
        String r4 = r2.a();
        if (r2.a != SchemaInfo.Host.MICROAPP) goto L38;
        boolean r5 = Intrinsics.areEqual(r4, this.b);
        boolean r6 = true;
        if ((!r5) == true) goto L38;
        SchemaInfo r7 = SchemaInfo.b.b(this.a);
        if (r7 != null) goto L13;
        return r9;
    L13:
        SchemaInfo.VersionType r8 = (SchemaInfo.VersionType) r7.c.getValue();
        Intrinsics.checkNotNullParameter(r8, "versionType");
        r3.a.put("version_type", r8.name());
        JSONObject r10 = r7.n;
        if (r10 != SchemaInfo.p) goto L17;
        r6 = false;
    L17:
        if (r6 == true) goto L21;
        r10 = null;
    L21:
        if (r10 != null) goto L23;
        r10 = SchemaInfo.b.a(r1, r7.c("inspect"));
        r7.n = r10;
    L23:
        if (r10 != null) goto L25;
        return r9;
    L25:
        Intrinsics.checkNotNullParameter(r10, "inspect");
        r3.a.put("inspect", SchemaInfo.b.c(r10));
        String r11 = r7.c("ide_inspect_version");
        if (r11 != null) goto L28;
        return r9;
    L28:
        r3.e("ide_inspect_version", r11);
        String r12 = r7.c("ide_config");
        if (r12 != null) goto L31;
        return r9;
    L31:
        r3.e("ide_config", r12);
        SchemaInfo r13 = r3.c();
        if (r13 == null) goto L37;
        String r14 = r13.h();
        if (r14 == null) goto L37;
        r9 = r14;
    L37:
        qo0.a.a("MiniAppAnchorDebugContextService", "增加调试参数，增加参数后的 schema ：".concat(r9));
    L38:
        return r9;
    }

    public final int i(String r5) {
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 101;
    L9:
        SchemaInfo.s.getClass();
        SchemaInfo r1 = SchemaInfo.b.b(r5);
        if (r1 == null) goto L12;
        String r2 = r1.a();
    L13:
        String r3 = "";
        if ((!Intrinsics.areEqual(this.b, "")) == true) goto L16;
    L24:
        return 102;
    L16:
        if (Intrinsics.areEqual(r2, this.b) == false) goto L24;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.a = r5;
        SchemaInfo r6 = SchemaInfo.b.b(r5);
        if (r6 == null) goto L23;
        String r7 = r6.c("url");
        if (r7 == null) goto L23;
        r3 = r7;
    L23:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        return 1;
    L12:
        r2 = null;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public final void j(int r3) {
        if (r3 != 1) goto L5;
        k();
        return;
    L5:
        if (r3 == 102) goto L7;
        f2.c(s1.B(2131920848), 0);
        return;
    L7:
        f2.c(s1.B(2131920847), 0);
    }

    public static final void g(MiniAppAnchorDebugContextService r3, Context r4) {
        r3.getClass();
        x0.d r5 = new x0.d();
        r5.b = r4;
        r5.a = 4;
        r5.c = "提示";
        r5.d = "无法唤起调试工具, 请尝试重新开播";
        f r6 = f.a;
        x0.c[] r0 = r5.g;
        x0.c r2 = r0[0];
        if (r2 != null) goto L5;
        r2 = new x0.c();
        r0[0] = r2;
    L5:
        r2.a = "确定";
        r2.b = r6;
        x0.b.g(new x0(r5.b, r5));
    }
}
