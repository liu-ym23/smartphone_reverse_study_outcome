package com.obric.memorydata.memory.ui.automemory;

import android.content.Context;
import android.widget.ImageView;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryIconResolver;", "", "<init>", "()V", "resolve", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryResolvedIcon;", "rule", "Lcom/obric/memorydata/database/entity/MemoryRuleEntity;", "iconKey", "", "resolveDrawableRes", "", "setIcon", "", "imageView", "Landroid/widget/ImageView;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f10710a = null;

    static {
        f10710a = new n();
    }

    private n() {
    }

    public final AutoMemoryResolvedIcon a(MemoryRuleEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "rule");
        return a(r2.getIconKey());
    }

    public final AutoMemoryResolvedIcon a(String r2) {
        if (r2 == null) goto L6;
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r1 == null) goto L6;
        String r3 = r1.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r3, "toLowerCase(...)");
    L7:
        AutoMemoryResolvedIcon r4 = AutoMemoryResolvedIcon.Companion.a(r3);
        if (r4 == null) goto L11;
        return r4;
    L11:
        return AutoMemoryResolvedIcon.GENERAL_3;
    L6:
        r3 = null;
        goto L7
    }

    public final void a(ImageView r5, MemoryRuleEntity r6) {
        Intrinsics.checkNotNullParameter(r5, "imageView");
        Intrinsics.checkNotNullParameter(r6, "rule");
        AutoMemoryResolvedIcon r4 = a(r6);
        k r0 = k.f10681a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "getContext(...)");
        r5.setImageDrawable(r0.a(r1, r4.getDrawableRes(), r6.getIconColorKey()));
        r5.clearColorFilter();
    }
}
