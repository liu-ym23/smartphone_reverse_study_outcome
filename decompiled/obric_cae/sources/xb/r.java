package xb;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.appcompat.widget.y;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public final class r extends y {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public yb.g f13837q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DayOfWeek f13838r;

    public r(Context r8, DayOfWeek r10) {
        super(r8, null);
        this.f13837q = yb.g.f14111a;
        setGravity(17);
        setTextAlignment(4);
        this.f13838r = r10;
        setText(this.f13837q.a(r10));
    }
}
