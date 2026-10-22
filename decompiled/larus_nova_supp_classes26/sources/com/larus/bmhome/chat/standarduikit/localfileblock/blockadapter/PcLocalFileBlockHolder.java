package com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFilePage;
import com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileRepository;
import com.larus.bmhome.chat.standarduikit.localfileblock.view.PcLocalFileCardView;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LocalFileBlock;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.utils.logger.FLogger;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kc8.y;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PcLocalFileBlockHolder extends jc8.b<c> {
    public PcLocalFileCardView d;
    public PcRemoteFilePage e;
    public f f;
    public g g;
    public Job h;

    public final String c() {
        return "PcLocalFileBlockHolder";
    }

    public final void l() {
        f r0 = this.f;
        if (r0 == null) goto L9;
        PcRemoteFilePage r1 = this.e;
        if (r1 == null) goto L9;
        LiveData<PcRemoteFilePage.b> r2 = r1.getState();
        if (r2 == null) goto L9;
        r2.removeObserver(r0);
    L9:
        this.f = null;
        this.e = null;
        g r3 = this.g;
        if (r3 == null) goto L12;
        PcRemoteFileRepository.h.removeObserver(r3);
    L12:
        this.g = null;
        Job r4 = this.h;
        if (r4 == null) goto L15;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L15:
        this.h = null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, com.larus.bmhome.chat.standarduikit.localfileblock.view.PcLocalFileCardView] */
    public final void i() {
        l();
        ConstraintLayout r0 = this.d;
        if (r0 == null) goto L5;
        ExposeXTrackerExtKt.e(r0);
    L5:
        ?? r1 = this.d;
        if (r1 == 0) goto L12;
        r1.c = false;
        vl8.h r2 = r1.e;
        if (r2 == null) goto L10;
        r1.removeCallbacks(r2);
    L10:
        r1.e = null;
        r1.setOnClickListener(null);
        r1.a.b.setOnClickListener(null);
        r1.S5(false);
        r1.setContentDescription(null);
        return;
    }

    public PcLocalFileBlockHolder() {
    }

    public final jc8.d f(jc8.a r2) {
        c r3 = (c) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup, com.larus.bmhome.chat.standarduikit.localfileblock.view.PcLocalFileCardView] */
    /* JADX WARN: Type inference failed for: r0v24, types: [androidx.lifecycle.Observer, com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.f] */
    /* JADX WARN: Type inference failed for: r13v0, types: [android.view.ViewGroup, com.larus.bmhome.chat.standarduikit.localfileblock.view.PcLocalFileCardView] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.e, kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r8v2, types: [androidx.lifecycle.Observer, com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.g] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void g(jc8.a r20) {
        final c r8 = (c) r20;
        Intrinsics.checkNotNullParameter(r8, "blockModel");
        l();
        ConstraintLayout r0 = this.d;
        if (r0 == null) goto L5;
        ExposeXTrackerExtKt.e(r0);
    L5:
        ?? r1 = this.d;
        if (r1 == 0) goto L11;
        r1.c = false;
        vl8.h r2 = r1.e;
        if (r2 == null) goto L10;
        r1.removeCallbacks(r2);
    L10:
        r1.e = null;
        r1.setOnClickListener(null);
        r1.a.b.setOnClickListener(null);
        r1.S5(false);
        r1.setContentDescription(null);
    L11:
        final com.larus.bmhome.chat.standarduikit.localfileblock.remote.g r11 = r8.o();
        if (r11 == null) goto L75;
        kc8.b r3 = jc8.c.a(this, kc8.b.class);
        if (r3 == null) goto L17;
        y r12 = r3.a;
    L18:
        final ?? r13 = this.d;
        if (r13 == 0) goto L76;
        boolean r14 = FlowDriveSdkService.a.o();
        if (r12 == null) goto L24;
        Fragment r15 = r12.a;
    L25:
        if (r12 == null) goto L27;
        boolean r4 = Intrinsics.areEqual(r12.h, Boolean.TRUE);
    L28:
        if (r4 == true) goto L35;
        if (r15 == null) goto L35;
        PcRemoteFilePage.a r5 = PcRemoteFilePage.Companion;
        if (r12 == null) goto L33;
        Function0 r6 = r12.f;
    L34:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r15, "fragment");
        PcRemoteFilePage r7 = (PcRemoteFilePage) new ViewModelProvider(r15).get(PcRemoteFilePage.class);
        PcRemoteFilePage.access$bind(r7, r15, r6);
        PcRemoteFilePage r9 = r7;
    L36:
        this.e = r9;
        String r10 = r11.d;
        if (r10 != null) goto L39;
        r10 = "";
    L39:
        String r16 = r10;
        String r17 = r11.e;
        if (r9 == null) goto L48;
        LiveData<PcRemoteFilePage.b> r18 = r9.getState();
        if (r18 == null) goto L48;
        PcRemoteFilePage.b r19 = (PcRemoteFilePage.b) r18.getValue();
        if (r19 == null) goto L48;
        Map<String, String> r21 = r19.b;
        if (r21 == null) goto L48;
        String r22 = r21.get(r11.a);
    L49:
        if (r9 == null) goto L59;
        LiveData<PcRemoteFilePage.b> r23 = r9.getState();
        if (r23 == null) goto L59;
        PcRemoteFilePage.b r24 = (PcRemoteFilePage.b) r23.getValue();
        if (r24 == null) goto L59;
        com.larus.bmhome.chat.standarduikit.localfileblock.remote.g r25 = r24.a;
        if (r25 == null) goto L59;
        if (com.larus.bmhome.chat.standarduikit.localfileblock.remote.d.a(r25, r11) != true) goto L59;
        boolean r26 = true;
    L60:
        boolean r110 = r26;
        String r111 = r22;
        final y r27 = r12;
        final PcRemoteFilePage r28 = r9;
        PcRemoteFilePage r112 = r9;
        final ?? r29 = new d(this, r8, r27, r13, r28, r11);
        Intrinsics.checkNotNullParameter(r16, "fileName");
        Intrinsics.checkNotNullParameter(r29, "onClick");
        r13.b = r14;
        SimpleDraweeView r30 = r13.a.e;
        h19.b.a.getClass();
        r30.setActualImageResource(h19.b.a(h19.b.d(r17)));
        r13.a.g.setText(r16);
        r13.U5(r111);
        r13.setOnClickListener(new vl8.i(r29));
        r13.a.b.setOnClickListener(new vl8.j(r29));
        vl8.h r31 = r13.e;
        if (r31 == null) goto L63;
        r13.removeCallbacks(r31);
    L63:
        r13.e = null;
        r13.S5(false);
        r13.T5(r110);
        if (r15 == null) goto L68;
        LiveData r32 = r15.getViewLifecycleOwnerLiveData();
        if (r32 == null) goto L68;
        LifecycleOwner r113 = (LifecycleOwner) r32.getValue();
    L69:
        if (r112 == null) goto L73;
        if (r113 == null) goto L73;
        final LifecycleOwner r33 = r113;
        final y r34 = r12;
        final ?? r35 = new e(r13, r33, r8, this, r34);
        ?? r36 = new f(r13, r11);
        r112.getState().observe(r113, r36);
        this.f = r36;
        final LifecycleOwner r37 = r113;
        ?? r38 = new g(this, r11, r37, r13, r35);
        PcRemoteFileRepository.h.observe(r113, r38);
        this.g = r38;
        k(r11, r113, r13, r35);
        return;
    L73:
        return;
    L68:
        r113 = null;
    L59:
        r26 = false;
    L48:
        r22 = null;
        goto L49
    L33:
        r6 = null;
    L35:
        r9 = null;
        goto L36
    L27:
        r4 = false;
        goto L28
    L24:
        r15 = null;
        goto L25
    L76:
        return;
    L17:
        r12 = null;
        goto L18
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.larus.bmhome.chat.standarduikit.localfileblock.view.PcLocalFileCardView] */
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        ?? r0 = new PcLocalFileCardView(r2.getContext());
        this.d = r0;
        return r0;
    }

    public static final Object j(PcLocalFileBlockHolder r4, com.larus.bmhome.chat.standarduikit.localfileblock.remote.g r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof PcLocalFileBlockHolder$hasCachedFile$1) == false) goto L7;
        PcLocalFileBlockHolder$hasCachedFile$1 r0 = (PcLocalFileBlockHolder$hasCachedFile$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = true;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L14;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L21 CancellationException -> L26
    L19:
        if (r7 != null) goto L25;
    L23:
        r3 = false;
        goto L25
    L25:
        return Boxing.boxBoolean(r3);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        PcRemoteFileRepository r9 = PcRemoteFileRepository.a;     // Catch: Exception -> L21 CancellationException -> L26
        r0.label = 1;     // Catch: Exception -> L21 CancellationException -> L26
        r7 = PcRemoteFileRepository.f(r5, r0);     // Catch: Exception -> L21 CancellationException -> L26
        if (r7 != r8) goto L19;
        return r8;
    L26:
        e = move-exception;
        throw e;
    L21:
        e = move-exception;
        FLogger.a.w("PcLocalFileBlockHolder", "stage=cache_state_failed type=".concat(e.getClass().getSimpleName()));
    L7:
        r0 = new PcLocalFileBlockHolder$hasCachedFile$1(r4, r6);
        goto L8
    }

    public final void k(com.larus.bmhome.chat.standarduikit.localfileblock.remote.g r14, LifecycleOwner r15, PcLocalFileCardView r16, Function0<Unit> r17) {
        Job r0 = this.h;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.h = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r15), null, null, new PcLocalFileBlockHolder$refreshCachedFile$1(r16, this, r14, r17, null), 3, null);
    }

    public final void m(c r8, y r9, PcLocalFileCardView r10, boolean r11) {
        boolean r0 = false;
        if (r9 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r9.h, Boolean.TRUE);
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        com.larus.bmhome.chat.standarduikit.localfileblock.remote.g r2 = r8.o();
        PcRemoteFilePage r3 = this.e;
        by7.e r4 = null;
        String r5 = "";
        if (r3 == null) goto L19;
        if (r2 == null) goto L12;
        String r6 = r2.a;
    L13:
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        if (r3.isSourceDeviceOffline(r6) != true) goto L19;
        r0 = true;
        goto L19
    L12:
        r6 = null;
    L19:
        if (r10.c == false) goto L22;
        String r12 = "loading";
    L30:
        String r7 = com.larus.im.bean.message.a.s(r8.j());
        if (r7 != null) goto L33;
        r7 = "";
    L33:
        String r13 = r8.j().getMessageId();
        if (r13 != null) goto L36;
        r13 = "";
    L36:
        String r14 = r8.j().getConversationId();
        if (r14 != null) goto L39;
        r14 = "";
    L39:
        BlockContent r15 = ((jc8.a) r8).a.getContent();
        if (r15 == null) goto L46;
        LocalFileBlock r16 = r15.getLocalFileBlock();
        if (r16 == null) goto L46;
        String r17 = r16.type;
        if (r17 == null) goto L46;
        String r18 = r17.toLowerCase(Locale.ROOT);
    L47:
        if (r18 == null) goto L50;
        r5 = r18;
    L50:
        if (r9 == null) goto L52;
        r4 = r9.c;
    L52:
        JSONObject r19 = new JSONObject();
        Intrinsics.checkNotNullParameter(r19, "params");
        r19.putOpt("chat_id", r7);     // Catch: JSONException -> L55
        r19.putOpt(MusicAppletPage.KEY_MESSAGE_ID, r13);     // Catch: JSONException -> L55
        r19.putOpt(MusicAppletPage.KEY_CONVERSATION_ID, r14);     // Catch: JSONException -> L55
        r19.put("content_type", ShareType.FILE);     // Catch: JSONException -> L55
        r19.putOpt("content_sec_type", r5);     // Catch: JSONException -> L55
        r19.putOpt("status", r12);     // Catch: JSONException -> L55
        r19.putOpt("is_dispatch", "1");     // Catch: JSONException -> L55
    L58:
        if (r11 == false) goto L60;
        String r110 = "general_agent_artifact_result_card_click";
    L61:
        by7.a r20 = new by7.a(r110);
        if (r4 == null) goto L64;
        r20.b = r4;
    L64:
        r20.a.merge(new TrackParams().merge(r19));
        r20.b();
        return;
    L60:
        r110 = "general_agent_artifact_result_card_show";
    L55:
        e = move-exception;
        FLogger.a.e("ArtifactResultCardEventHelper", "build artifact result card event failed", e);
    L46:
        r18 = null;
        goto L47
    L22:
        if (r10.b == true) goto L24;
    L29:
        r12 = "disable";
        goto L30
    L24:
        if (r10.d == true) goto L28;
        if (r11 == false) goto L29;
        if (r0 == true) goto L29;
    L28:
        r12 = "able";
        goto L30
    L5:
        r1 = false;
        goto L6
    }
}
