package com.obric.assistant.block.omni.create_shortcut;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OClickActionBlock;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.larus.utils.y0;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.block.base.CheckLastMessageBlockHolder;
import com.obric.assistant.card.databinding.ObricBlockCreateShortcutBinding;
import kc8.y;
import kc8.z;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class CreateShortcutIntentBlockHolder extends CheckLastMessageBlockHolder<com.obric.assistant.block.omni.create_shortcut.a> {
    public static final /* synthetic */ int x = 0;
    public ObricBlockCreateShortcutBinding p;
    public y q;
    public z r;
    public String s;
    public final CoroutineScope t;
    public Job u;
    public Lifecycle v;
    public final CreateShortcutIntentBlockHolder$resumeObserver$1 w;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.block.base.CheckLastMessageBlockHolder
    public final String c() {
        return "CreateShortcutIntentBlockHolder";
    }

    public final void o() {
        ObricBlockCreateShortcutBinding r0 = this.p;
        if (r0 == null) goto L7;
        TextView r1 = r0.b;
        if (r1 == null) goto L7;
        e1.o(r1);
    L7:
        ObricBlockCreateShortcutBinding r2 = this.p;
        if (r2 == null) goto L21;
        ViewGroup.MarginLayoutParams r3 = null;
        if (r2 == null) goto L14;
        RelativeLayout r4 = r2.a;
        if (r4 == null) goto L14;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
    L16:
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r3 = (ViewGroup.MarginLayoutParams) r5;
    L18:
        if (r3 == null) goto L22;
        r3.topMargin = 0;
        r3.bottomMargin = c7.b(8);
        return;
    L22:
        return;
    L14:
        r5 = null;
        goto L16
    }

    public final void p() {
        String r0 = this.s;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return;
    L12:
        if (l() == true) goto L14;
        return;
    L14:
        Job r3 = this.u;
        if (r3 == null) goto L17;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L17:
        this.u = BuildersKt.launch$default(this.t, null, null, new CreateShortcutIntentBlockHolder$checkShortcutSaved$1(r0, this, null), 3, null);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.block.omni.create_shortcut.CreateShortcutIntentBlockHolder$resumeObserver$1] */
    public CreateShortcutIntentBlockHolder() {
        this.t = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.w = new CreateShortcutIntentBlockHolder$resumeObserver$1(this);
    }

    @Override // com.obric.assistant.block.base.CheckLastMessageBlockHolder
    public final void i() {
        super.i();
        FLogger.a.i("CreateShortcutBlockHolder", "onViewRecycled");
        Job r0 = this.u;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.u = null;
        Lifecycle r1 = this.v;
        if (r1 == null) goto L8;
        r1.removeObserver(this.w);
    L8:
        this.v = null;
    }

    @Override // com.obric.assistant.block.base.CheckLastMessageBlockHolder
    public final jc8.d f(jc8.a r6) {
        com.obric.assistant.block.omni.create_shortcut.a r7 = (com.obric.assistant.block.omni.create_shortcut.a) r6;
        Intrinsics.checkNotNullParameter(r7, "blockModel");
        Intrinsics.checkNotNullParameter(r7, "blockModel");
        boolean r0 = r7.m();
        boolean r8 = r7.n();
        if (r0 == false) goto L7;
        if (r8 == false) goto L7;
        return new jc8.d(c7.b(16), c7.b(12), c7.b(16), c7.b(14));
    L7:
        if (r0 == true) goto L17;
        if (r8 == false) goto L15;
        if (l() == false) goto L19;
        return new jc8.d(c7.b(16), c7.b(6), c7.b(16), c7.b(14));
    L19:
        return new jc8.d(c7.b(16), 0, c7.b(16), c7.b(8));
    L15:
        return new jc8.d(c7.b(16), c7.b(6), c7.b(16), c7.b(6));
    L17:
        return new jc8.d(c7.b(16), c7.b(12), c7.b(16), c7.b(6));
    }

    @Override // com.obric.assistant.block.base.CheckLastMessageBlockHolder
    public final void g(jc8.a r13) {
        final com.obric.assistant.block.omni.create_shortcut.a r14 = (com.obric.assistant.block.omni.create_shortcut.a) r13;
        Intrinsics.checkNotNullParameter(r14, "blockModel");
        super.g(r14);
        FLogger r0 = FLogger.a;
        r0.i("CreateShortcutBlockHolder", "onBindBlockView");
        kc8.b r1 = jc8.c.a(this, kc8.b.class);
        Lifecycle r3 = null;
        if (r1 == null) goto L5;
        y r2 = r1.a;
    L6:
        this.q = r2;
        if (r2 == null) goto L9;
        z r4 = r2.A;
    L10:
        this.r = r4;
        final ObricBlockCreateShortcutBinding r5 = this.p;
        if (r5 != null) goto L13;
        r0.w("CreateShortcutBlockHolder", "binding is null");
        return;
    L13:
        BlockContent r6 = ((jc8.a) r14).a.getContent();
        if (r6 == null) goto L34;
        final OClickActionBlock r7 = r6.getOClickActionBlock();
        if (r7 == null) goto L34;
        if (l() == true) goto L21;
        r0.i("CreateShortcutBlockHolder", "onBindBlockView: not latest message, gone");
        o();
        return;
    L21:
        int r8 = p0.a;
        JSONObject r9 = p0.b(y0.f(y0.j(r7.clickAction), LynxResourceModule.DATA_KEY));
        String r10 = NameKeys.UnloadStrategy_No_Strategy;
        this.s = r9.optString("messageId", NameKeys.UnloadStrategy_No_Strategy);
        e1.x(r5.a);
        TextView r11 = r5.b;
        String r12 = r7.content;
        if (r12 == null) goto L25;
        r10 = r12;
    L25:
        r11.setText(r10);
        we8.a.b(r5.b, i5.m(), false, null, null, 12);
        e1.d(r5.b, new b(r5, r7, r14));
        r5.b.setOnLongClickListener(new c(this));
        y r15 = this.q;
        if (r15 == null) goto L30;
        Fragment r16 = r15.a;
        if (r16 == null) goto L30;
        r3 = r16.getLifecycle();
    L30:
        this.v = r3;
        if (r3 == null) goto L33;
        r3.addObserver(this.w);
    L33:
        p();
        return;
    L34:
        o();
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        FLogger.a.i("CreateShortcutBlockHolder", "onCreatedBlockView");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131563936, r4, false);
        RelativeLayout r0 = (RelativeLayout) r5;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r5, 2131389991);
        if (r2 == null) goto L7;
        this.p = new ObricBlockCreateShortcutBinding(r0, r2);
        return r0;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131389991)));
    }

    @Override // com.obric.assistant.block.base.CheckLastMessageBlockHolder
    public final void m(boolean r4) {
        FLogger.a.i("CreateShortcutBlockHolder", "onLastMessageStateChange: isLastestMessage = " + r4);
        if (r4 == true) goto L6;
        o();
        return;
    }
}
