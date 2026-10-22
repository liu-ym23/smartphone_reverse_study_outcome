package com.obric.memorydata.screencapture.a;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import com.obric.memorydata.sdk.screencapture.ViewTreeNode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ<\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ<\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/screencapture/utils/ViewTreeUtil;", "", "<init>", "()V", "MAX_VIEW_TREE_DEPTH", "", "flattenNodesToTextList", "", "", "node", "Landroid/view/accessibility/AccessibilityNodeInfo;", "visibleOnly", "", "dfsNodeWithTextList", "", "result", "", "guard", "Lcom/obric/memorydata/screencapture/utils/ViewTreeTraversalGuard;", "depth", "flattenNodesToCleanList", "Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "dfsNodeWithCleanList", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12768a = null;

    static {
        f12768a = new b();
    }

    private b() {
    }

    private final void a(AccessibilityNodeInfo r19, List<ViewTreeNode> r20, boolean r21, a<AccessibilityNodeInfo> r22, int r23) {
        List<ViewTreeNode> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        if (r22.a(r19, r23) == true) goto L5;
        return;
    L5:
        if (r21 == true) goto L7;
    L9:
        CharSequence r3 = r19.getText();
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L25;
        CharSequence r5 = r19.getContentDescription();
        if (r5 != null) goto L20;
    L23:
        boolean r6 = true;
    L24:
        if (r6 == false) goto L25;
    L51:
        int r11 = r19.getChildCount();
        int r12 = 0;
    L52:
        if (r12 >= r11) goto L57;
        AccessibilityNodeInfo r7 = r19.getChild(r12);
        if (r7 == null) goto L56;
        f12768a.a(r7, r2, r21, r22, r23 + 1);
    L56:
        r12 = r12 + 1;
        goto L52
    L57:
        return;
    L20:
        if (r5.length() == 0) goto L23;
        r6 = false;
    L25:
        Rect r8 = new Rect();
        r19.getBoundsInScreen(r8);
        CharSequence r9 = r19.getText();
        if (r9 == null) goto L31;
        String r10 = r9.toString();
        if (r10 == null) goto L31;
        String r13 = r10;
    L32:
        CharSequence r14 = r19.getContentDescription();
        if (r14 == null) goto L38;
        String r15 = r14.toString();
        if (r15 == null) goto L38;
        String r16 = r15;
    L39:
        String r17 = r19.getViewIdResourceName();
        if (r17 != null) goto L42;
        String r18 = "";
    L43:
        CharSequence r24 = r19.getClassName();
        if (r24 == null) goto L49;
        String r25 = r24.toString();
        if (r25 == null) goto L49;
        String r110 = r25;
    L50:
        r2.add(new ViewTreeNode(r13, r16, r18, r110, r8, r19.isVisibleToUser()));
    L49:
        r110 = "";
        goto L50
    L42:
        r18 = r17;
    L38:
        r16 = "";
    L31:
        r13 = "";
        goto L32
    L12:
        if (r3.length() == 0) goto L15;
        r4 = false;
        goto L16
    L7:
        if (r19.isVisibleToUser() == true) goto L9;
    }

    public final List<ViewTreeNode> a(AccessibilityNodeInfo r7, boolean r8) {
        List<ViewTreeNode> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        a<AccessibilityNodeInfo> r4 = new a(64);
        if (r7 == null) goto L5;
        f12768a.a(r7, r6, r8, r4, 0);
    L5:
        return r6;
    }
}
