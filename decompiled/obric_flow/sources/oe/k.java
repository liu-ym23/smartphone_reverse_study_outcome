package oe;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f20555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l9.g f20556b;

    public k(RecyclerView r5, l9.g r10) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        Intrinsics.checkNotNullParameter(r10, "helper");
        this.f20555a = r5;
        this.f20556b = r10;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        RecyclerView r5 = this.f20555a;
        if (r5 != null) goto L5;
    L8:
        boolean r10 = false;
    L9:
        if (r10 == false) goto L56;
        RecyclerView.LayoutManager r11 = r5.getLayoutManager();
        if ((r11 instanceof LinearLayoutManager) == false) goto L14;
        LinearLayoutManager r12 = (LinearLayoutManager) r11;
    L15:
        if (r12 == null) goto L52;
        int r13 = r12.findFirstVisibleItemPosition();
        int r14 = r12.findLastVisibleItemPosition();
        if (r13 == (-1)) goto L53;
        int r15 = r14 - r13;
        if (r15 < 0) goto L54;
        l9.g r16 = this.f20556b;
        if (r15 < 0) goto L45;
        int r17 = r16.f19561b;
        if (r17 != (-1)) goto L27;
        r16.f19561b = r13;
        r16.f19562c = r14;
    L25:
        if (r13 >= (r14 + 1)) goto L57;
        r13 = r13 + 1;
        goto L25
    L57:
        return;
    L27:
        if (r13 == r17) goto L35;
        if (r13 <= r17) goto L31;
    L29:
        if (r17 >= r13) goto L34;
        r17 = r17 + 1;
    L34:
        r16.f19561b = r13;
        goto L35
    L31:
        int r18 = r13;
    L32:
        if (r18 >= r17) goto L34;
        r18 = r18 + 1;
    L35:
        int r19 = r16.f19562c;
        if (r14 == r19) goto L55;
        if (r14 <= r19) goto L40;
    L38:
        if (r19 >= r14) goto L43;
        r19 = r19 + 1;
    L43:
        r16.f19562c = r14;
        return;
    L40:
        int r20 = r14;
    L41:
        if (r20 >= r19) goto L43;
        r20 = r20 + 1;
        goto L41
    L55:
        return;
    L45:
        r16.getClass();
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L14:
        r12 = null;
        goto L15
    L56:
        return;
    L5:
        if (r5.getVisibility() != 0) goto L8;
        r10 = r5.getGlobalVisibleRect(new Rect());
        goto L9
    }
}
