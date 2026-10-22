package com.bytedance.android.livesdk.dslservice.view;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt1.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tRF\u0010\u0014\u001a&\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000bj\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/dslservice/view/DSLDebugTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "Lyt1/o;", "a", "Lyt1/o;", "getTemplateData", "()Lyt1/o;", "setTemplateData", "(Lyt1/o;)V", "templateData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getData", "()Ljava/util/HashMap;", "setData", "(Ljava/util/HashMap;)V", "data", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "dslservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DSLDebugTextView extends AppCompatTextView {
    public o a;
    public HashMap<String, Object> b;

    public final HashMap<String, Object> getData() {
        return this.b;
    }

    public final o getTemplateData() {
        return this.a;
    }

    public DSLDebugTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void setData(HashMap<String, Object> r1) {
        this.b = r1;
    }

    public final void setTemplateData(o r1) {
        this.a = r1;
    }
}
