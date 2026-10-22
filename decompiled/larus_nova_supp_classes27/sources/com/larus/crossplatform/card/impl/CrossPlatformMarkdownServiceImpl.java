package com.larus.crossplatform.card.impl;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.bytedance.ai.widget.view.WidgetBoxView;
import com.larus.bmhome.chat.api.ICrossPlatformMarkdownService;
import com.larus.bmhome.chat.api.r;
import com.larus.bmhome.chat.layout.widget.AppletWidget;
import com.larus.bmhome.chat.list.cell.widget.WidgetCell;
import com.larus.bmhome.chat.standarduikit.markdown.view.MarkdownAppletContainer;
import com.larus.list.arch.IFlowListCell;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0014"}, d2 = {"Lcom/larus/crossplatform/card/impl/CrossPlatformMarkdownServiceImpl;", "Lcom/larus/bmhome/chat/api/ICrossPlatformMarkdownService;", "<init>", "()V", "isWidgetCell", "", "cell", "", "getAllVisibleWidget", "", "Landroid/view/View;", "clearAllVisibleWidget", "", "provideCustomDataHandler", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "findVisibleWidget", "viewGroup", "Landroid/view/ViewGroup;", "findMarkdownAppletWidget", "findAllMarkdownAppletWidgetsRecursive", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CrossPlatformMarkdownServiceImpl implements ICrossPlatformMarkdownService {
    public CrossPlatformMarkdownServiceImpl() {
    }

    public final List<View> b() {
        List r1 = WidgetCell.h;
        return new ArrayList(WidgetCell.h);
    }

    public final void c() {
        List r0 = WidgetCell.h;
        ((ArrayList) WidgetCell.h).clear();
    }

    public static List e(ViewGroup r3) {
        ArrayList r0 = new ArrayList();
        Iterator r4 = ViewGroupKt.getChildren(r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L18;
        MarkdownAppletContainer r1 = (View) r4.next();
        if ((r1 instanceof MarkdownAppletContainer) == true) goto L7;
        if ((r1 instanceof ViewGroup) == false) goto L4;
        r0.addAll(e((ViewGroup) r1));
        goto L4
    L7:
        AppletWidget r2 = r1.a;
        if (r2 == null) goto L12;
        r r5 = r2.getWidgetContainer();
        if (r5 == null) goto L12;
        WidgetBoxView r6 = r5.a();
    L13:
        if (r6 == null) goto L4;
        r0.add(r6);
    L12:
        r6 = null;
        goto L13
    L18:
        return r0;
    }

    public final void a(ViewGroup r3) {
        if (r3 == null) goto L7;
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        Iterator r4 = SequencesKt.filter(CollectionsKt.asSequence(e(r3)), new a()).iterator();
    L5:
        if (r4.hasNext() == false) goto L9;
        View r0 = (View) r4.next();
        ((ArrayList) WidgetCell.h).add(r0);
        goto L5
    L9:
        return;
    }

    public final boolean d(IFlowListCell r2) {
        return Reflection.getOrCreateKotlinClass(WidgetCell.class).isInstance(r2);
    }
}
