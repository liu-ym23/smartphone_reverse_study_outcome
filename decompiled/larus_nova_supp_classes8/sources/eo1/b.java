package eo1;

import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.room.h;
import hh1.v0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import nz.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends com.bytedance.android.livesdk.chatroom.ui.framework.base.a {
    public final PropertyOwner<Boolean> A;
    public r s;
    public com.bytedance.android.live.pushstream.d t;
    public v0 u;
    public h.a v;
    public final List<View.OnTouchListener> w;
    public final List<DialogInterface.OnKeyListener> x;
    public boolean y;
    public final PropertyOwner<Boolean> z;

    public static final class a {
    }

    static {
    }

    public b(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, false);
        this.w = new ArrayList();
        this.x = new ArrayList();
        Boolean r0 = Boolean.FALSE;
        this.z = new PropertyOwner(r0);
        this.A = new PropertyOwner(r0);
    }
}
