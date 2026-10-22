package com.obric.memorydata.markdown.custom;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ba;
import com.obric.memorydata.utils.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\n¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/markdown/custom/UrlActions;", "", "<init>", "()V", "showPicker", "", "context", "Landroid/content/Context;", "urls", "", "", "showMenu", "url", "open", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f9998a = null;

    static {
        f9998a = new m();
    }

    private m() {
    }

    private static final void a(Context r1, String r2, View r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        f9998a.b(r4, r2);
    }

    private static final void b(Context r1, String r2, View r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        f9998a.b(r4, r2);
    }

    private static final void c(Context r1, String r2, View r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        a.a(r4, "url", r2);
        String r5 = r4.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_copied, TypedValues.Custom.S_STRING, "markdown_action_copied"));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        ba.a(r4, r5, 80);
    }

    public static /* synthetic */ void lambda$bQXx4Lhxz4kqdMgBGrl53iwbB9o(Context r0, String r1, View r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$kKxsDpvjHw0S7FGOXEtKwV14VZ8(Context r0, String r1, View r2) {
        c(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$q9MZC6vgkBlbe4hygyS89yCyHWc(Context r0, String r1, View r2) {
        a(r0, r1, r2);
    }

    public final void a(Context r6, final String r7) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r7, "url");
        List<String> r0 = CollectionsKt.mutableListOf(new String[]{r5.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_open_webpage, TypedValues.Custom.S_STRING, "markdown_action_open_webpage")), r5.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_copy, TypedValues.Custom.S_STRING, "markdown_action_copy"))});
        List<? extends View.OnClickListener> r8 = CollectionsKt.mutableListOf(new View.OnClickListener[]{new $$Lambda$m$bQXx4Lhxz4kqdMgBGrl53iwbB9o(r5, r7), new $$Lambda$m$kKxsDpvjHw0S7FGOXEtKwV14VZ8(r5, r7)});
        h r1 = new h(r5);
        r1.a(r7);
        r1.a(r0, r8);
        r1.a();
    }

    public final void a(Context r5, List<String> r6) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r7, "urls");
        List<String> r8 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"));
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        final String r2 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        r1.add(new $$Lambda$m$q9MZC6vgkBlbe4hygyS89yCyHWc(r4, r2));
        goto L4
    L6:
        List<? extends View.OnClickListener> r11 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        h r0 = new h(r4);
        String r12 = r4.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_open_webpage, TypedValues.Custom.S_STRING, "markdown_action_open_webpage"));
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");
        r0.a(r12);
        r0.a(r8, r11);
        r0.a();
    }

    public final void b(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intent r4 = z.f13269a.a(r3);
        r4.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        a.a(r1, r4);
    }
}
