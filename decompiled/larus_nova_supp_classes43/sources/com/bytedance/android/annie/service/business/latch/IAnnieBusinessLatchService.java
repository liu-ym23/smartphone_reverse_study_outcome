package com.bytedance.android.annie.service.business.latch;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.lynx.tasm.LynxView;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IAnnieBusinessLatchService extends com.bytedance.android.annie.service.a {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/service/business/latch/IAnnieBusinessLatchService$PrefetchStrategy;", "", "Latch", "Nothing", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum PrefetchStrategy extends Enum<PrefetchStrategy> {
        public static final PrefetchStrategy Latch = null;
        public static final PrefetchStrategy Nothing = null;
        public static final /* synthetic */ PrefetchStrategy[] a = null;

        public static PrefetchStrategy valueOf(String r1) {
            return (PrefetchStrategy) r27.a.a(PrefetchStrategy.class, r1);
        }

        public static PrefetchStrategy[] values() {
            return (PrefetchStrategy[]) a.clone();
        }

        static {
            PrefetchStrategy r0 = new PrefetchStrategy("Latch", 0);
            Latch = r0;
            PrefetchStrategy r1 = new PrefetchStrategy("Nothing", 1);
            Nothing = r1;
            a = new PrefetchStrategy[]{r0, r1};
        }

        public PrefetchStrategy(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
        public String a;
        public long b;
        public String c;
        public String d;
        public String e;
        public String f;
        public final Map<String, String> g;

        public a() {
            this.a = "";
            this.c = "fullscreen";
            this.d = "";
            this.f = "";
            this.g = new LinkedHashMap();
        }
    }

    public interface b extends Disposable {
        void X0(IHybridComponent r1);

        void Y0(LynxView r1);
    }

    b C0(Context r1, String r10, String r11, Uri r12, long r13, a r14, boolean r15);

    void P0(Uri r1);

    void d(String r1, boolean r10);

    a e(long r1, String r10, String r11, String r12);

    String i(Uri r1);

    Pair<PrefetchStrategy, String> k(Uri r1, String r10);

    int w1(Context r1, String r10, Uri r11, a r12);
}
