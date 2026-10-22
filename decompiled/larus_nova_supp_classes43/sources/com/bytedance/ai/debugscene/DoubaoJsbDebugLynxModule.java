package com.bytedance.ai.debugscene;

import android.content.Context;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J&\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/debugscene/DoubaoJsbDebugLynxModule;", "Lcom/lynx/jsbridge/LynxModule;", "context", "Landroid/content/Context;", "param", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "runtimeHandle", "Lcom/bytedance/ai/debugscene/JsbDebugRuntimeHandle;", "panelMessageDispatcher", "Lcom/bytedance/ai/debugscene/AIDebugPanelMessageDispatcher;", "postMessage", "", "channel", "", com.bytedance.android.ec.core.event.a.KEY_MSG, "Lcom/lynx/react/bridge/ReadableMap;", "postPanelMessage", "type", "callback", "Lcom/lynx/react/bridge/Callback;", "ai-sdk-debug-scene_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoJsbDebugLynxModule extends LynxModule {
    private final k0 panelMessageDispatcher;
    private final q2 runtimeHandle;

    public static /* synthetic */ void a(Callback r0, int r1, String r10, String r11) {
        postPanelMessage$lambda$1(r0, r1, r10, r11);
    }

    public DoubaoJsbDebugLynxModule(Context r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        k0 r0 = null;
        if ((r11 instanceof q2) == false) goto L5;
        q2 r12 = (q2) r11;
    L6:
        this.runtimeHandle = r12;
        if ((r11 instanceof k0) == false) goto L9;
        r0 = (k0) r11;
    L9:
        this.panelMessageDispatcher = r0;
        return;
    L5:
        r12 = null;
        goto L6
    }

    @LynxMethod
    public final void postMessage(String r10, ReadableMap r11) {
        Function2<? super q2, ? super String, Unit> r0 = p2.a;
        q2 r1 = this.runtimeHandle;
        if (r11 == null) goto L5;
        String r12 = m4.f.b(r11).toString();
    L7:
        if (Intrinsics.areEqual(r10, "doubao_jsb_debug") == true) goto L9;
        com.bytedance.ai.utils.g.a.w("JsbDebugNativeChannel", "ignore message from unexpected channel: " + r10);
        return;
    L9:
        if (r12 != null) goto L11;
    L14:
        boolean r13 = true;
    L15:
        if (r13 == false) goto L17;
        com.bytedance.ai.utils.g.a.w("JsbDebugNativeChannel", "ignore empty JSB debug message");
        return;
    L17:
        if (r1 != null) goto L19;
        com.bytedance.ai.utils.g.a.w("JsbDebugNativeChannel", "drop JSB debug message without runtime handle");
        return;
    L19:
        com.bytedance.ai.utils.g r14 = com.bytedance.ai.utils.g.a;
        r14.d("JsbDebugNativeChannel", "receive runtime message, handle:" + r1.a + ", messageLength:" + r12.length());
        Function2<? super q2, ? super String, Unit> r15 = p2.a;
        if (r15 == null) goto L22;
        r15.invoke(r1, r12);
        return;
    L22:
        r14.w("JsbDebugNativeChannel", "JSB debug handler is not active");
        return;
    L11:
        if (StringsKt.isBlank(r12) == true) goto L14;
        r13 = false;
        goto L15
    L5:
        r12 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ai.debugscene.o2] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @LynxMethod
    public final void postPanelMessage(String r10, String r11, final Callback r12) {
        ?? r0 = new o2(r12);
        boolean r13 = true;
        if (r10 != null) goto L5;
    L8:
        boolean r14 = true;
    L10:
        if (r14 == true) goto L23;
        if (r11 != null) goto L13;
    L16:
        if (r13 == true) goto L23;
        k0 r15 = this.panelMessageDispatcher;
        if (r15 == 0) goto L21;
        r15.a(r10, r11, r0);
        return;
    L21:
        r0.a(-2, "MESSAGE_TYPE_NOT_REGISTERED", null);
        return;
    L13:
        if (StringsKt.isBlank(r11) == true) goto L16;
        r13 = false;
    L23:
        r0.a(-3, "INVALID_PARAM", null);
        return;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r14 = false;
        goto L10
    }

    private static final void postPanelMessage$lambda$1(Callback r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, MessageIndication.MESSAGE_TYPE_MSG);
        if (r10 == null) goto L6;
        JavaOnlyMap r14 = new JavaOnlyMap();
        r14.putInt("code", r11);
        r14.putString(MessageIndication.MESSAGE_TYPE_MSG, r12);
        r14.putString("data", r13);
        Unit r15 = Unit.INSTANCE;
        r10.invoke(new Object[]{r14});
        return;
    }
}
