package com.bytedance.android.livesdk.interactivity;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdkapi.depend.model.live.PublicScreenBottomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.publicscreen.AbsPublicScreenBottomWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/PublicScreenBottomPlaceHolder;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/room/placeholder/widget/d;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenBottomPlaceHolder extends RoomRecyclableWidget implements com.bytedance.android.livesdk.room.placeholder.widget.d {
    public u a;
    public Disposable b;

    public static final class a<T> implements h80.a {
        public final /* synthetic */ PublicScreenBottomPlaceHolder a;

        public a(PublicScreenBottomPlaceHolder r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Room r6 = (Room) r5;
            if (r6 == null) goto L23;
            PublicScreenBottomInfo r7 = r6.publicScreenBottomInfo;
            if (r7 == null) goto L7;
            List r8 = r7.getCardList();
        L9:
            if (r8 != null) goto L11;
        L17:
            int r9 = t.a;
            ALogger.i("PSBottomWidget", "bottom card list is null");
        L18:
            DataCenter r10 = ((Widget) this.a).dataCenter;
            if (r10 == null) goto L21;
            r10.put("cmd_specific_widget_loaded", "2");
        L21:
            int r11 = t.a;
            ALogger.i("PSBottomWidget", "PublicScreenBottomPlaceHolder onLoad");
            return;
        L11:
            if ((!r8.isEmpty()) != true) goto L17;
            PublicScreenBottomPlaceHolder r1 = this.a;
            u r2 = new u(r8, ((Widget) r1).containerView);
            w r13 = new w();
            Intrinsics.checkNotNullParameter(r13, "sche");
            r2.b = r13;
            Unit r14 = Unit.INSTANCE;
            r1.a = r2;
            RoomContext r15 = this.a.getRoomContext();
            if (r15 == null) goto L18;
            com.bytedance.live.datacontext.j r16 = r15.getInteractivityContext();
            if (r16 == null) goto L18;
            r16.c(new PublicScreenBottomPlaceHolder$onLoad$1$2(this));
            goto L18
        L7:
            r8 = null;
            goto L9
        }
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        u r0 = this.a;
        if (r0 == null) goto L12;
        Iterator<Map.Entry<AbsPublicScreenBottomWidget, v>> r2 = r0.a.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().getValue().onUnload();
        goto L6
    L8:
        r0.e = false;
        com.bytedance.android.livesdk.interactivity.a r3 = r0.b;
        if (r3 == null) goto L11;
        r3.c();
    L11:
        r0.b = null;
    L12:
        this.a = null;
        Disposable r1 = this.b;
        if (r1 == null) goto L15;
        r1.dispose();
    L15:
        this.b = null;
        int r4 = t.a;
        ALogger.i("PSBottomWidget", "PublicScreenBottomPlaceHolder onUnload");
    }

    public PublicScreenBottomPlaceHolder() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r10v0 ??, still in use, count: 1, list:
          (r10v0 ?? I:java.lang.Object) from 0x0087: INVOKE (r0v12 ?? I:java.util.HashMap), (r12v0 ?? I:java.lang.Object), (r10v0 ?? I:java.lang.Object) VIRTUAL call: java.util.HashMap.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:16777351)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public final void attachWidget(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r10v0 ??, still in use, count: 1, list:
          (r10v0 ?? I:java.lang.Object) from 0x0087: INVOKE (r0v12 ?? I:java.util.HashMap), (r12v0 ?? I:java.lang.Object), (r10v0 ?? I:java.lang.Object) VIRTUAL call: java.util.HashMap.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:16777351)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r12v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    public final void detachWidget(IExternalWidget r4) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        if (wq(r4) == false) goto L19;
        u r1 = this.a;
        if (r1 == null) goto L20;
        Intrinsics.checkNotNullParameter(r4, "widget");
        if ((r4 instanceof AbsPublicScreenBottomWidget) == true) goto L9;
        r4 = null;
    L9:
        AbsPublicScreenBottomWidget r5 = (AbsPublicScreenBottomWidget) r4;
        if (r5 == null) goto L21;
        v r0 = r1.a.get(r5);
        if (r0 == null) goto L17;
        r0.onViewWillDetach();
        r1.g.removeAllViews();
        r0.onViewDetached();
        r0.onUnload();
        com.bytedance.android.livesdk.interactivity.a r2 = r1.b;
        if (r2 == null) goto L17;
        r2.b(r0);
    L17:
        r1.a.remove(r5);
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void onLoad(Object[] r2) {
        if (isAlive() == false) goto L5;
        runWithRoomEntered(new a(this));
        return;
    L5:
        int r3 = t.a;
        ALogger.e("PSBottomWidget", "PublicScreenBottomPlaceHolder is not alive");
    }

    public final void requestDismiss(IExternalWidget r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        if (wq(r3) == false) goto L8;
        int r0 = t.a;
        ALogger.i("PSBottomWidget", "outer request dismiss");
        u r1 = this.a;
        if (r1 == null) goto L9;
        r1.b(r3);
        return;
    L9:
        return;
    }

    public final void requestShow(IExternalWidget r5) {
        Intrinsics.checkNotNullParameter(r5, "widget");
        if (wq(r5) == false) goto L23;
        final u r1 = this.a;
        if (r1 == null) goto L24;
        Intrinsics.checkNotNullParameter(r5, "widget");
        if ((r5 instanceof AbsPublicScreenBottomWidget) == true) goto L9;
        IExternalWidget r0 = null;
    L10:
        AbsPublicScreenBottomWidget r2 = (AbsPublicScreenBottomWidget) r0;
        if (r2 == null) goto L29;
        int r3 = t.a;
        ALogger.i("PSBottomWidget", ((AbsPublicScreenBottomWidget) r5).getBusinessName() + " request show");
        if (ArraysKt.contains(r1.c, r2.getBusinessName()) == true) goto L16;
        return;
    L16:
        if (r1.d.contains(r2.getBusinessName()) == false) goto L26;
        final v r6 = r1.a.get(r2);
        if (r6 == null) goto L27;
        PublicScreenBottomWidgetManager$requestShow$1$startAction$1 r4 = PublicScreenBottomWidgetManager$requestShow$1$startAction$1.INSTANCE;
        Function2<v, ViewGroup, Unit> r7 = new PublicScreenBottomWidgetManager$requestShow$$inlined$let$lambda$1(r6, r1);
        com.bytedance.android.livesdk.interactivity.a r8 = r1.b;
        if (r8 == null) goto L28;
        r8.d(r6, r1.g, r4, r7);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L29:
        return;
    L9:
        r0 = r5;
        goto L10
    L24:
        return;
    }

    public final boolean wq(IExternalWidget r2) {
        if (isAlive() == true) goto L5;
    L13:
        return false;
    L5:
        if (isInitialized() == false) goto L13;
        if (((Widget) this).containerView == null) goto L13;
        if (this.a == null) goto L13;
        if ((r2 instanceof AbsPublicScreenBottomWidget) == false) goto L13;
        return true;
    }

    public final void requestWidgetHeight(IExternalWidget r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "widget");
        Intrinsics.checkNotNullParameter(r1, "widget");
    }
}
