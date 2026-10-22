package com.obric.oui.scrollbar;

import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u001c\u0010\u000b\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001c\u0010\r\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/scrollbar/RecyclerViewScrollBarHelper;", "", "()V", "TAG", "", "adjustScrollBarVisibilityDynamic", "", "Landroidx/recyclerview/widget/RecyclerView;", "maxScreens", "", "adjustScrollBarVisibilityEfficiently", "updateScrollBarVisibilityByItemCount", MemoryInfoSectionEditActivity.KIND_SCENE, "updateScrollBarWithStableHeight", "contentHeight", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14413a = null;

    static {
        f14413a = new a();
    }

    private a() {
    }

    private final void a(RecyclerView r3, float r4, int r5) {
        int r2 = r3.computeVerticalScrollExtent();
        if (r2 <= 0) goto L6;
        if (r5 <= 0) goto L6;
        float r0 = r5 / r2;
    L8:
        if (r0 < r4) goto L10;
        boolean r6 = true;
    L12:
        if (r3.isVerticalScrollBarEnabled() == r6) goto L14;
        r3.setVerticalScrollBarEnabled(r6);
    L14:
        Log.d("RecyclerViewScrollBarHelper", "updateScrollBarWithStableHeight, isVerticalScrollBarEnabled: " + r3.isVerticalScrollBarEnabled() + ", contentScreens: " + r0 + ", contentHeight: " + r5 + ", visibleHeight: " + r2);
        return;
    L10:
        r6 = false;
    L6:
        r0 = 0.0f;
        goto L8
    }

    private final void a(RecyclerView r10, float r11, String r12) {
        RecyclerView.LayoutManager r9 = r10.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r9, LinearLayoutManager.class) == false) goto L5;
        LinearLayoutManager r13 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r9, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r13 != null) goto L8;
        return;
    L8:
        int r0 = r13.findFirstVisibleItemPosition();
        int r14 = r13.findLastVisibleItemPosition();
        boolean r2 = true;
        int r1 = (r14 - r0) + 1;
        RecyclerView.Adapter r3 = r10.getAdapter();
        if (r3 != null) goto L11;
        int r4 = 0;
    L13:
        if (r1 <= 0) goto L16;
        if (r4 <= 0) goto L16;
        float r7 = r4 / r1;
    L18:
        if (r7 >= r11) goto L21;
        r2 = false;
    L21:
        r10.setVerticalScrollBarEnabled(r2);
        Log.d("RecyclerViewScrollBarHelper", "updateScrollBarVisibilityByItemCount, scene: " + r12 + ", isVerticalScrollBarEnabled: " + r10.isVerticalScrollBarEnabled() + ", estimatedScreens: " + r7 + ", totalItemCount: " + r4 + ", visibleItemCount: " + r1 + ", firstVisibleItemPosition: " + r0 + ", lastVisibleItemPosition: " + r14);
        return;
    L16:
        Log.e("RecyclerViewScrollBarHelper", "updateScrollBarVisibilityByItemCount, error! totalItemCount: " + r4 + ", visibleItemCount: " + r1);
        r7 = 0.0f;
        goto L18
    L11:
        r4 = r3.getItemCount();
        goto L13
    L5:
        r13 = null;
        goto L6
    }

    public static final /* synthetic */ void a(a r0, RecyclerView r1, float r2, int r3) {
        r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ void a(a r0, RecyclerView r1, float r2, String r3) {
        r0.a(r1, r2, r3);
    }
}
