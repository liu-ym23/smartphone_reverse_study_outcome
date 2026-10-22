package com.larus.chat.job.impl.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.bmhome.view.screenmenu.x0;
import com.larus.im.bean.job.AIJob;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ChatJobListComponent$onViewCreated$listAdapter$3 extends FunctionReferenceImpl implements Function3<View, AIJob, Integer, Boolean> {
    public ChatJobListComponent$onViewCreated$listAdapter$3(Object r8) {
        super(3, r8, ChatJobListComponent.class, "showJobMenu", "showJobMenu(Landroid/view/View;Lcom/larus/im/bean/job/AIJob;I)Z", 0);
    }

    public final Boolean invoke(final View r97, final AIJob r98, final int r99) {
        Intrinsics.checkNotNullParameter(r97, "p0");
        Intrinsics.checkNotNullParameter(r98, "p1");
        final ChatJobListComponent r7 = (ChatJobListComponent) ((CallableReference) this).receiver;
        int r2 = ChatJobListComponent.w;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r7, "<this>");
        final Fragment r3 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7);
        final x0 r9 = r7.p;
        boolean r4 = false;
        if (r9 != null) goto L5;
        FLogger.a.e("ChatJobListComponent", "showJobMenu skipped: screenMenu is null job=" + ChatJobListComponent.a.a(r98));
    L32:
        return Boolean.valueOf(r4);
    L5:
        ICoreInputAbility r6 = s1a.d.a(r7).getAbility(ICoreInputAbility.class);
        if (r6 == null) goto L8;
        r6.qp(true);
    L8:
        f1 r8 = s1a.d.a(r7).getAbility(f1.class);
        if (r8 == null) goto L11;
        r8.NL(false);
    L11:
        Context r10 = r3.requireContext();
        if (r98.getStatus() != 2) goto L14;
        l0 r11 = new l0(4, 0, gz8.f.b("scheduledTasks_task_moreMenu_resume"), null, null, null, null, null, null, false, false, null, 2131240039, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127);
    L15:
        l0[] r12 = new l0[5];
        r12[0] = new l0(1, 0, gz8.f.b("scheduledTasks_task_moreMenu_openChat"), null, null, null, null, null, null, false, false, null, 2131240033, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127);
        r12[1] = new l0(2, 0, gz8.f.b("scheduledTasks_task_moreMenu_runNow"), null, null, null, null, null, null, false, false, null, 2131240040, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127);
        r12[2] = r11;
        if (r98.getJobType() != 3) goto L18;
        l0 r13 = new l0(7, 0, gz8.f.b("triggerTasks_details"), null, null, null, null, null, null, false, false, null, 2131240035, null, false, false, Integer.valueOf(gz8.g.b(r10)), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -135174, 127);
    L19:
        r12[3] = r13;
        String r17 = gz8.f.b("button_delete");
        int r14 = gz8.g.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        r12[4] = new l0(6, 0, r17, null, null, Integer.valueOf(v19.c.b(2130970996, r10, 2131102650)), null, null, null, false, false, null, 2131240034, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4134, 127);
        List r15 = CollectionsKt.listOf(r12);
        final ArrayList r16 = new ArrayList();
        Iterator r18 = r15.iterator();
    L21:
        if (r18.hasNext() == false) goto L30;
        Object r19 = r18.next();
        if (((l0) r19).a == 2) goto L25;
    L27:
        boolean r110 = false;
    L28:
        if (r110 == true) goto L21;
        r16.add(r19);
        goto L21
    L25:
        if (r98.getJobType() == 1) goto L27;
        r110 = true;
        goto L28
    L30:
        FLogger.a.i("ChatJobListComponent", "showJobMenu job=" + ChatJobListComponent.a.a(r98) + " items=" + CollectionsKt.joinToString$default(r16, null, null, null, 0, null, new a(), 31, null));
        r9.i(new d(r7, r97));
        Bitmap r111 = Bitmap.createBitmap(Math.max(1, r97.getWidth()), Math.max(1, r97.getHeight()), Bitmap.Config.ARGB_8888);
        r97.draw(new Canvas(r111));
        r9.j(r97, true, r111, new e(r3, r16, r98, r9, r7, r99));
        r4 = true;
        goto L32
    L18:
        r13 = new l0(5, 0, gz8.f.b("button_edit"), null, null, null, null, null, null, false, false, null, 2131240036, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127);
        goto L19
    L14:
        r11 = new l0(3, 0, gz8.f.b("scheduledTasks_task_moreMenu_Pause"), null, null, null, null, null, null, false, false, null, 2131240038, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127);
        goto L15
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((View) r1, (AIJob) r2, ((Number) r3).intValue());
    }
}
