package com.obric.oui.orecyclerview.widget;

import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f14049a;

    public static final class Config {
        public static final Config c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f14050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StableIdMode f14051b;

        public static final enum StableIdMode extends Enum<StableIdMode> {
            private static final /* synthetic */ StableIdMode[] $VALUES = null;
            public static final StableIdMode ISOLATED_STABLE_IDS = null;
            public static final StableIdMode NO_STABLE_IDS = null;
            public static final StableIdMode SHARED_STABLE_IDS = null;

            static {
                StableIdMode r0 = new StableIdMode("NO_STABLE_IDS", 0);
                NO_STABLE_IDS = r0;
                StableIdMode r1 = new StableIdMode("ISOLATED_STABLE_IDS", 1);
                ISOLATED_STABLE_IDS = r1;
                StableIdMode r3 = new StableIdMode("SHARED_STABLE_IDS", 2);
                SHARED_STABLE_IDS = r3;
                $VALUES = new StableIdMode[]{r0, r1, r3};
            }

            private StableIdMode(String r1, int r2) {
                super(r1, r2);
            }

            public static StableIdMode valueOf(String r2) {
                return (StableIdMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(StableIdMode.class, r2), StableIdMode.class, "com.obric.memorydata.plugin");
            }

            public static StableIdMode[] values() {
                return (StableIdMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StableIdMode[].class, "com.obric.memorydata.plugin");
            }
        }

        static {
            c = new Config(true, StableIdMode.NO_STABLE_IDS);
        }

        Config(boolean r1, StableIdMode r2) {
            this.f14050a = r1;
            this.f14051b = r2;
        }
    }

    public ConcatAdapter(Config r3, List<? extends RecyclerView.Adapter<? extends RecyclerView.v>> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f14049a = new g(this, r3);
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        a((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r6.next(), RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        super.b_(this.f14049a.c());
    }

    @SafeVarargs
    public ConcatAdapter(Config r1, RecyclerView.Adapter<? extends RecyclerView.v>... r2) {
        this(r1, Arrays.asList(r2));
    }

    @SafeVarargs
    public ConcatAdapter(RecyclerView.Adapter<? extends RecyclerView.v>... r2) {
        this(Config.c, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r1) {
        return this.f14049a.b(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(RecyclerView.Adapter<? extends RecyclerView.v> r1, RecyclerView.v r2, int r3) {
        return this.f14049a.a(r1, r2, r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.v a(ViewGroup r1, int r2) {
        return this.f14049a.a(r1, r2);
    }

    public List<? extends RecyclerView.Adapter<? extends RecyclerView.v>> a() {
        return Collections.unmodifiableList(this.f14049a.b());
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.Adapter.StateRestorationPolicy r1) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r1) {
        this.f14049a.a(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r1, int r2) {
        this.f14049a.a(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView r1) {
        this.f14049a.a(r1);
    }

    public boolean a(RecyclerView.Adapter<? extends RecyclerView.v> r1) {
        return this.f14049a.a(r1);
    }

    void b(RecyclerView.Adapter.StateRestorationPolicy r1) {
        super.a(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void b(RecyclerView.v r1) {
        this.f14049a.c(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void b(RecyclerView r1) {
        this.f14049a.b(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void b_(boolean r1) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public long c(int r1) {
        return this.f14049a.a(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public boolean c(RecyclerView.v r1) {
        return this.f14049a.d(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.f14049a.a();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void d(RecyclerView.v r1) {
        this.f14049a.b(r1);
    }
}
