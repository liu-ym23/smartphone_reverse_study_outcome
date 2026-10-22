package com.obric.memorydata.markdown.custom;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/markdown/custom/IdentifierActions;", "", "<init>", "()V", "showMenu", "", "context", "Landroid/content/Context;", EventBody.KEY_VALUE, "", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9982a = null;

    static {
        f9982a = new c();
    }

    private c() {
    }

    private static final void a(Context r1, String r2, View r3) {
        a.a((Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin"), MemoryKeyInfoEntity.KEY_IDENTIFIER, r2);
    }

    public static /* synthetic */ void lambda$IF3tyMt9J03ZSTr70ygU3luKqQU(Context r0, String r1, View r2) {
        a(r0, r1, r2);
    }

    public final void a(Context r6, String r7) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r7, EventBody.KEY_VALUE);
        final String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L8;
        return;
    L8:
        List<String> r10 = CollectionsKt.mutableListOf(new String[]{r5.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_copy, TypedValues.Custom.S_STRING, "markdown_action_copy"))});
        List<? extends View.OnClickListener> r0 = CollectionsKt.mutableListOf(new View.OnClickListener[]{new $$Lambda$c$IF3tyMt9J03ZSTr70ygU3luKqQU(r5, r8)});
        h r1 = new h(r5);
        r1.a(r8);
        r1.a(r10, r0);
        r1.a();
        return;
    L5:
        r9 = false;
        goto L6
    }
}
