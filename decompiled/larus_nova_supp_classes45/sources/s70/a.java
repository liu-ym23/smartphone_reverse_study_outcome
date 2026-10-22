package s70;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import h70.b;
import java.util.List;
import s70.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a<Flag extends b<? extends h70.b>, T extends h70.b> {
    public T a;

    /* JADX INFO: renamed from: s70.a$a, reason: collision with other inner class name */
    public interface InterfaceC0275a {
        void To(LayerDescriptorList r1);
    }

    public a() {
    }

    public abstract void a(List<? extends Flag> r1);
}
