package com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess;

import android.text.Layout;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.light.processor.c0;
import com.ss.android.lark.widget.span.PrefixSpanStyle;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public boolean A;
    public MessagePermissionUtil.ReceiveAuthorizationState B;
    public ValidateIMFileResult C;
    public boolean D;
    public boolean E;
    public final boolean F;
    public InterfaceC0038b G;
    public HashMap<String, HashMap<Integer, Layout>> H;
    public HashMap<String, HashMap<Integer, Layout>> I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public int Q;
    public int R;
    public c0.b S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public PrefixSpanStyle Y;
    public boolean Z;
    public List<String> a;
    public boolean a0;
    public List<String> b;
    public boolean b0;
    public boolean c;
    public boolean c0;
    public boolean d;
    public boolean d0;
    public boolean e;
    public boolean e0;
    public boolean f;
    public boolean f0;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;
    public boolean m;
    public ValidateResult n;
    public boolean o;
    public String p;
    public String q;
    public boolean r;
    public boolean s;
    public Integer t;
    public int u;
    public Layout.Alignment v;
    public boolean w;
    public int x;
    public int y;
    public CodeBlockV2ProcessParams z;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b$b, reason: collision with other inner class name */
    public interface InterfaceC0038b {
        Integer a();
    }

    static {
    }

    public b() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.l = BuildConfig.FLAVOR;
        this.m = true;
        this.n = new ValidateResult(ResultType.ALLOW);
        this.o = true;
        this.p = BuildConfig.FLAVOR;
        this.q = BuildConfig.FLAVOR;
        this.u = -1;
        this.v = Layout.Alignment.ALIGN_NORMAL;
        this.x = 17;
        this.y = -1;
        this.B = MessagePermissionUtil.ReceiveAuthorizationState.NORMAL_STATE;
        this.D = true;
        this.E = true;
        this.F = true;
        this.H = new HashMap();
        this.I = new HashMap();
        this.J = true;
        this.K = true;
        this.Q = -1;
        this.R = -1;
        this.T = -1;
        this.U = 1;
        this.X = UIHelper.dp2px(5.0f);
        this.Y = PrefixSpanStyle.NORMAL;
    }

    public final void a(ValidateResult r2) {
        Intrinsics.checkNotNullParameter(r2, "previewValidateResult");
        this.n = r2;
    }
}
