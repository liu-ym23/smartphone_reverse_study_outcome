package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator2;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements UDTabLayoutCoordinator2.a {
    public final /* synthetic */ MmRecordingContentController a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingUITab.values().length];
            r0[MmRecordingUITab.SUBTITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmRecordingUITab.SUMMARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public f(MmRecordingContentController r1) {
        this.a = r1;
    }

    public final void a(int r5, com.larksuite.component.universe_design.tab.b r6) {
        Intrinsics.checkNotNullParameter(r6, "tab");
        h r7 = (h) ListProtector.get(this.a.l, r5);
        r6.b(r7.getTitle());
        View r0 = r6.e;
        MmRecordingContentController r1 = this.a;
        MmRecordingUITab r2 = r7.getTabType();
        r1.getClass();
        int r3 = MmRecordingContentController.b.a[r2.ordinal()];
        if (r3 == 1) goto L8;
        if (r3 != 2) goto L7;
        int r4 = 2131384056;
    L9:
        r0.setId(r4);
        TextView r8 = r6.a();
        r8.setTypeface(Typeface.DEFAULT_BOLD);
        MmRecordingUITab r9 = r7.getTabType();
        int r10 = a.a[r9.ordinal()];
        if (r10 == 1) goto L15;
        if (r10 != 2) goto L14;
        int r11 = uvb.b.a;
        uvb.a.b(r8, uvb.c.g);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        int r12 = uvb.b.a;
        uvb.a.b(r8, uvb.c.f);
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r4 = 2131384055;
        goto L9
    }
}
