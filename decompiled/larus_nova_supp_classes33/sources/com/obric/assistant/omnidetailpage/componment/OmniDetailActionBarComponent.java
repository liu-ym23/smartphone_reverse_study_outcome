package com.obric.assistant.omnidetailpage.componment;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.obric.assistant.card.databinding.ObricFragmentOmniDetailBinding;
import com.obric.assistant.omnidetailpage.blockview.base.StopButton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 (2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001(B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0013H\u0002J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0012\u0010#\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130%H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lcom/obric/assistant/omnidetailpage/componment/OmniDetailActionBarComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/obric/assistant/omnidetailpage/componment/IOmniDetailActionBarAbility;", "<init>", "()V", "binding", "Lcom/obric/assistant/card/databinding/ObricFragmentOmniDetailBinding;", "getBinding", "()Lcom/obric/assistant/card/databinding/ObricFragmentOmniDetailBinding;", "binding$delegate", "Lkotlin/Lazy;", "omniParam", "Lcom/obric/assistant/omnidetailpage/model/OmniDetailParam;", "getOmniParam", "()Lcom/obric/assistant/omnidetailpage/model/OmniDetailParam;", "omniParam$delegate", "taskStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "currentMessageId", "", "getCurrentMessageId", "()Ljava/lang/String;", "currentMessageId$delegate", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "initObserver", "updateState", "state", "getTaskStatus", "statusStr", "updateButtonState", "getTaskStatusFlow", "Lkotlinx/coroutines/flow/StateFlow;", "isTaskFinished", "", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniDetailActionBarComponent extends BaseContentWidget implements a {
    public static final /* synthetic */ int q = 0;
    public final Lazy m;
    public final Lazy n;
    public final StateFlowImpl o;
    public final Lazy p;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/omnidetailpage/componment/OmniDetailActionBarComponent$Companion$TaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Running", "Terminated", "Completed", "Fail", "NoTask", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum TaskStatus extends Enum<TaskStatus> {
            public static final TaskStatus Completed = null;
            public static final TaskStatus Fail = null;
            public static final TaskStatus NoTask = null;
            public static final TaskStatus Running = null;
            public static final TaskStatus Terminated = null;
            public static final /* synthetic */ TaskStatus[] a = null;
            public static final /* synthetic */ EnumEntries b = null;

            public static EnumEntries<TaskStatus> getEntries() {
                return b;
            }

            static {
                TaskStatus r0 = new TaskStatus("Running", 0);
                Running = r0;
                TaskStatus r1 = new TaskStatus("Terminated", 1);
                Terminated = r1;
                TaskStatus r3 = new TaskStatus("Completed", 2);
                Completed = r3;
                TaskStatus r5 = new TaskStatus("Fail", 3);
                Fail = r5;
                TaskStatus r7 = new TaskStatus("NoTask", 4);
                NoTask = r7;
                TaskStatus[] r9 = {r0, r1, r3, r5, r7};
                a = r9;
                b = EnumEntriesKt.enumEntries(r9);
            }

            public static TaskStatus[] values() {
                return (TaskStatus[]) a.clone();
            }

            public static TaskStatus valueOf(String r1) {
                return (TaskStatus) r27.a.a(TaskStatus.class, r1);
            }

            public TaskStatus(String r1, int r2) {
                super(r1, r2);
            }
        }
    }

    static {
    }

    @Override // com.obric.assistant.omnidetailpage.componment.a
    public final boolean ss() {
        int r0 = ((Number) this.o.getValue()).intValue();
        if (r0 != Companion.TaskStatus.Terminated.ordinal()) goto L5;
    L10:
        return true;
    L5:
        if (r0 == Companion.TaskStatus.Completed.ordinal()) goto L10;
        if (r0 == Companion.TaskStatus.Fail.ordinal()) goto L10;
        return false;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if (r0 == null) goto L6;
        s1a.a.a(r0, this, a.class);
        return;
    }

    public OmniDetailActionBarComponent() {
        this.m = LazyKt.lazy(new f(this));
        this.n = LazyKt.lazy(new g(this));
        this.o = j1.a(Integer.valueOf(Companion.TaskStatus.NoTask.ordinal()));
        this.p = LazyKt.lazy(new h(this));
    }

    @Override // com.obric.assistant.omnidetailpage.componment.a
    public final StateFlowImpl Dy() {
        return this.o;
    }

    public final void onViewCreated(View r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r8, "view");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailActionBarComponent$initObserver$1(this, null), 3, null);
        ObricFragmentOmniDetailBinding r9 = (ObricFragmentOmniDetailBinding) this.m.getValue();
        if (r9 == null) goto L8;
        StopButton r10 = r9.i;
        if (r10 == null) goto L9;
        e1.d(r10, new i(this));
        return;
    L9:
        return;
    }

    @Override // com.obric.assistant.omnidetailpage.componment.a
    public final void qJ(String r4) {
        if (r4 == null) goto L24;
        StateFlowImpl r0 = this.o;
        int r1 = r4.hashCode();
        if (r1 == (-1065646633)) goto L19;
        if (r1 == (-217340118)) goto L15;
        if (r1 == 1566710597) goto L11;
    L21:
        int r5 = Companion.TaskStatus.Running.ordinal();
    L22:
        r0.setValue(Integer.valueOf(r5));
        return;
    L11:
        if (r4.equals("detail_task_complete") == false) goto L21;
        r5 = Companion.TaskStatus.Completed.ordinal();
        goto L22
    L15:
        if (r4.equals("detail_task_fail") == false) goto L21;
        r5 = Companion.TaskStatus.Fail.ordinal();
        goto L22
    L19:
        if (r4.equals("detail_task_interrupt") == false) goto L21;
        r5 = Companion.TaskStatus.Terminated.ordinal();
        goto L22
    }
}
