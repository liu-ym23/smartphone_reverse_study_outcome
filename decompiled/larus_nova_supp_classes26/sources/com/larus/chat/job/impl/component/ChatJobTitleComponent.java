package com.larus.chat.job.impl.component;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.chat.job.impl.experiment.ChatJobLarkEventSettings;
import com.larus.chat.job.impl.page.g0;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00060\u0001j\u0002`\u0002:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/chat/job/impl/component/ChatJobTitleComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "<init>", "()V", "titleView", "Landroid/view/View;", "onParentViewCreated", "", "onFragmentViewDestroyed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobTitleComponent extends ComponentFeature {
    public static final /* synthetic */ int i = 0;
    public View h;

    public static final class a {
    }

    static {
    }

    public final void A2() {
    }

    public final void B2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r0 == null) goto L18;
        ViewGroup r1 = (ViewGroup) r0.findViewById(2131377229);
        if (r1 == null) goto L20;
        r1.removeAllViews();
        View r2 = LayoutInflater.from(r1.getContext()).inflate(2131561892, r1, false);
        r1.addView(r2);
        this.h = r2;
        TextView r3 = (TextView) r2.findViewById(2131377231);
        if (r3 == null) goto L14;
        int r4 = g0.a;
        ChatJobLarkEventSettings.a.getClass();
        if (ChatJobLarkEventSettings.a() == false) goto L12;
        String r5 = gz8.f.b("auto_task");
    L13:
        r3.setText(r5);
        goto L14
    L12:
        r5 = gz8.f.b("scheduledTasks_screenTitle_scheduledTasks");
    L14:
        View r6 = r2.findViewById(2131377230);
        if (r6 == null) goto L19;
        e1.d(r6, new s(this));
        return;
    L19:
        return;
    L20:
        return;
    }

    public ChatJobTitleComponent() {
    }
}
