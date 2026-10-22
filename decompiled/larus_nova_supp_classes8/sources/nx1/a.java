package nx1;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.feedback.Question;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kx1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a<T extends c> extends FrameLayout implements b {
    public final Question a;

    public abstract lx1.b<T> getOptionFactory();

    public abstract /* synthetic */ String getSelectResult();

    public abstract /* synthetic */ String getSelectToast();

    public abstract /* synthetic */ Long getSubQuestionId();

    public final List<T> a() {
        return getOptionFactory().a(this.a.options);
    }

    public final Question getQuestion() {
        return this.a;
    }

    public a(Context r3, Question r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "question");
        super(r3, null, 0);
        this.a = r4;
    }
}
