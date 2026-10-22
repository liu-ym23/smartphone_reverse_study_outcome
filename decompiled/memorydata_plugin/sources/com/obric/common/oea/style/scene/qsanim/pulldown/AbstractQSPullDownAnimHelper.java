package com.obric.common.oea.style.scene.qsanim.pulldown;

import android.view.ViewGroup;
import com.obric.common.oea.style.scene.qsanim.a.c;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u001c\b&\u0018\u0000 Z2\u00020\u0001:\u0002Z[B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0010\u0010)\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010.J\b\u0010/\u001a\u00020*H\u0002J\b\u00100\u001a\u00020*H\u0002J\u0010\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u0010H\u0002J\u0010\u00103\u001a\u00020*2\u0006\u00102\u001a\u00020\u0010H\u0002J\u0010\u00104\u001a\u00020*2\u0006\u00102\u001a\u00020\u0010H\u0002J\u000e\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u0005J\u0006\u00107\u001a\u00020*J\u0010\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020\u001bH\u0002J\u000e\u0010:\u001a\u00020*2\u0006\u00106\u001a\u00020\u0005J\b\u0010;\u001a\u00020*H\u0002J\u0006\u0010<\u001a\u00020*J\u0006\u0010=\u001a\u00020*J\u0010\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020\f2\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010B\u001a\u00020*H&J\b\u0010C\u001a\u00020*H&J\b\u0010D\u001a\u00020*H&J\b\u0010E\u001a\u00020*H&J\u0018\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0010H'J\u0018\u0010H\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u001bH&J\b\u0010I\u001a\u00020*H&J\b\u0010J\u001a\u00020*H&J\b\u0010K\u001a\u00020*H&J\b\u0010L\u001a\u00020*H&J\u0010\u0010M\u001a\u00020*2\u0006\u00102\u001a\u00020\u0010H\u0002J\u001a\u0010N\u001a\u00020*2\u0006\u00102\u001a\u00020\u00102\b\b\u0002\u0010O\u001a\u00020\u001eH\u0002J\u0010\u0010P\u001a\u00020*2\u0006\u00102\u001a\u00020\u0010H\u0002J\u0010\u0010Q\u001a\u00020*2\u0006\u00102\u001a\u00020\u0010H\u0002J\u0006\u0010R\u001a\u00020*J\b\u0010S\u001a\u00020*H\u0017J\u0010\u0010T\u001a\u00020*2\b\u0010U\u001a\u0004\u0018\u00010%J\b\u0010V\u001a\u00020*H\u0002J\u000e\u0010W\u001a\u00020*2\u0006\u00106\u001a\u00020\u0005J\u0006\u0010X\u001a\u00020*J\u000e\u0010Y\u001a\u00020*2\u0006\u00106\u001a\u00020\u0005R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/pulldown/AbstractQSPullDownAnimHelper;", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/BaseViewGroupAnimHelper;", "rootView", "Landroid/view/ViewGroup;", "defInitScale", "", "defInitAlpha", "pullDownDistance", "enterExitControlPoint", "stretchTriggerPoint", "(Landroid/view/ViewGroup;FFFFF)V", "childEnterAnim", "Landroid/animation/Animator;", "childExitAnim", "childTransYProperties", "", "", "Lcom/obric/common/oea/style/scene/qsanim/common/SpringAnimUtils$CommonFloatProperty;", "draBarPerEnterAnim", "draBarPerExitAnim", "dragBar", "Lcom/obric/common/oea/style/scene/qsanim/common/AnimControlPoint;", "dragBarAnimEndListener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationEndListener;", "dragBarAnimUpdateListener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationUpdateListener;", "dragContinueTimesBeforeDragUp", "", "dragStartConsumed", "Lcom/obric/common/oea/style/scene/qsanim/common/KtExt$AutoExpireFlag;", "", "dragUpAnimPhase", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/AbstractQSPullDownAnimHelper$DragUpAnimPhase;", "lastDragBarY", "lastTouchMoveY", "openCloseAnimInterruptibleF", "qsPullDownAnimListener", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSPullDownAnimListener;", "getRootView", "()Landroid/view/ViewGroup;", "speedTar", "addAnimView", "", "view", "Landroid/view/View;", "animConfig", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSAnimConfig;", "cancelChildEnterAnim", "cancelChildExitAnim", "cancelCloseAnim", MemoryInfoSectionEditActivity.KIND_SCENE, "cancelOpenAnim", "cancelRunningAnim", "dragContinue", "y", "dragEnd", "dragFollow", "direction", "dragStart", "dragUp", "forcePlayCloseAnim", "forcePlayOpenAnim", "makeChildEnterAnim", "animDuration", "", "makeChildExitAnim", "onCancelChildEnterAnim", "onCancelChildExitAnim", "onCancelDragUpCloseAnim", "onCancelDragUpOpenAnim", "onDragDistanceAnimUpdated", "distance", "onDragFollow", "onPlayChildEnterAnim", "onPlayChildExitAnim", "onPlayDragUpCloseAnim", "onPlayDragUpOpenAnim", "playChildEnterAnim", "playChildExitAnim", "exitQuickly", "playCloseAnim", "playOpenAnim", "resetAnimState", "resetViewState", "setQSPullDownAnimListener", "listener", "stretchChildViews", "tryDragContinue", "tryDragEnd", "tryDragStart", "Companion", "DragUpAnimPhase", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbstractQSPullDownAnimHelper extends com.obric.common.oea.style.scene.qsanim.pulldown.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7839a = null;
    private static final com.obric.common.oea.style.scene.qsanim.a.a e = null;
    private final Map<String, c.a> c;
    private final ViewGroup d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/pulldown/AbstractQSPullDownAnimHelper$DragUpAnimPhase;", "", "(Ljava/lang/String;I)V", "NONE", "OPEN", "CLOSE", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    private static final enum DragUpAnimPhase extends Enum<DragUpAnimPhase> {
        private static final /* synthetic */ DragUpAnimPhase[] $VALUES = null;
        public static final DragUpAnimPhase CLOSE = null;
        public static final DragUpAnimPhase NONE = null;
        public static final DragUpAnimPhase OPEN = null;

        static {
            DragUpAnimPhase r1 = new DragUpAnimPhase("NONE", 0);
            NONE = r1;
            DragUpAnimPhase r2 = new DragUpAnimPhase("OPEN", 1);
            OPEN = r2;
            DragUpAnimPhase r3 = new DragUpAnimPhase("CLOSE", 2);
            CLOSE = r3;
            $VALUES = new DragUpAnimPhase[]{r1, r2, r3};
        }

        private DragUpAnimPhase(String r1, int r2) {
            super(r1, r2);
        }

        public static DragUpAnimPhase valueOf(String r2) {
            return (DragUpAnimPhase) ZeusTransformUtils.preCheckCast(Enum.valueOf(DragUpAnimPhase.class, r2), DragUpAnimPhase.class, "com.obric.memorydata.plugin");
        }

        public static DragUpAnimPhase[] values() {
            return (DragUpAnimPhase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DragUpAnimPhase[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/pulldown/AbstractQSPullDownAnimHelper$Companion;", "", "()V", "CHILD_TRANS_Y_PROPERTY", "", "FLING_DOWN_SPEED_THRESH", "", "FLING_UP_SPEED_THRESH", "TAG", "cubicEaseOutInterpolator", "Lcom/obric/common/oea/style/scene/qsanim/common/CubicEaseOutInterpolator;", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f7839a = new a(null);
        e = new com.obric.common.oea.style.scene.qsanim.a.a();
    }

    public static final /* synthetic */ Map a(AbstractQSPullDownAnimHelper r0) {
        return r0.c;
    }

    public final ViewGroup a() {
        return this.d;
    }
}
