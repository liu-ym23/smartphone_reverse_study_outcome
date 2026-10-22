package androidx.recyclerview.widget;

import android.util.Pair;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static final String TAG = "ConcatAdapter";
    private final ConcatAdapterController mController;

    public static final class Config {

        @NonNull
        public static final Config DEFAULT = null;
        public final boolean isolateViewTypes;

        @NonNull
        public final StableIdMode stableIdMode;

        public static final class Builder {
            private boolean mIsolateViewTypes;
            private StableIdMode mStableIdMode;

            public Builder() {
                Config r5 = Config.DEFAULT;
                this.mIsolateViewTypes = r5.isolateViewTypes;
                this.mStableIdMode = r5.stableIdMode;
            }

            @NonNull
            public Config build() {
                return new Config(this.mIsolateViewTypes, this.mStableIdMode);
            }

            @NonNull
            public Builder setIsolateViewTypes(boolean r5) {
                this.mIsolateViewTypes = r5;
                return this;
            }

            @NonNull
            public Builder setStableIdMode(@NonNull StableIdMode r5) {
                this.mStableIdMode = r5;
                return this;
            }
        }

        public static final enum StableIdMode extends Enum<StableIdMode> {
            private static final /* synthetic */ StableIdMode[] $VALUES = null;
            public static final StableIdMode ISOLATED_STABLE_IDS = null;
            public static final StableIdMode NO_STABLE_IDS = null;
            public static final StableIdMode SHARED_STABLE_IDS = null;

            static {
                StableIdMode r5 = new StableIdMode("NO_STABLE_IDS", 0);
                NO_STABLE_IDS = r5;
                StableIdMode r10 = new StableIdMode("ISOLATED_STABLE_IDS", 1);
                ISOLATED_STABLE_IDS = r10;
                StableIdMode r11 = new StableIdMode("SHARED_STABLE_IDS", 2);
                SHARED_STABLE_IDS = r11;
                $VALUES = new StableIdMode[]{r5, r10, r11};
            }

            private StableIdMode(String r5, int r10) {
                super(r5, r10);
            }

            public static StableIdMode valueOf(String r5) {
                return (StableIdMode) Enum.valueOf(StableIdMode.class, r5);
            }

            public static StableIdMode[] values() {
                return (StableIdMode[]) $VALUES.clone();
            }
        }

        static {
            DEFAULT = new Config(true, StableIdMode.NO_STABLE_IDS);
        }

        public Config(boolean r5, @NonNull StableIdMode r10) {
            this.isolateViewTypes = r5;
            this.stableIdMode = r10;
        }
    }

    @SafeVarargs
    public ConcatAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... r5) {
        this(Config.DEFAULT, r5);
    }

    public boolean addAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r5) {
        return this.mController.addAdapter(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int findRelativeAdapterPositionIn(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r5, @NonNull RecyclerView.ViewHolder r10, int r11) {
        return this.mController.getLocalAdapterPosition(r5, r10, r11);
    }

    @NonNull
    public List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getAdapters() {
        return Collections.unmodifiableList(this.mController.getCopyOfAdapters());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mController.getTotalCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r5) {
        return this.mController.getItemId(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r5) {
        return this.mController.getItemViewType(r5);
    }

    @NonNull
    public Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> getWrappedAdapterAndPosition(int r5) {
        return this.mController.getWrappedAdapterAndPosition(r5);
    }

    public void internalSetStateRestorationPolicy(@NonNull RecyclerView.Adapter.StateRestorationPolicy r5) {
        super.setStateRestorationPolicy(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView r5) {
        this.mController.onAttachedToRecyclerView(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder r5, int r10) {
        this.mController.onBindViewHolder(r5, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup r5, int r10) {
        return this.mController.onCreateViewHolder(r5, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView r5) {
        this.mController.onDetachedFromRecyclerView(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder r5) {
        return this.mController.onFailedToRecycleView(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder r5) {
        this.mController.onViewAttachedToWindow(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder r5) {
        this.mController.onViewDetachedFromWindow(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder r5) {
        this.mController.onViewRecycled(r5);
    }

    public boolean removeAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r5) {
        return this.mController.removeAdapter(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean r5) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setStateRestorationPolicy(@NonNull RecyclerView.Adapter.StateRestorationPolicy r5) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }

    @SafeVarargs
    public ConcatAdapter(@NonNull Config r5, @NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... r10) {
        this(r5, Arrays.asList(r10));
    }

    public boolean addAdapter(int r5, @NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r10) {
        return this.mController.addAdapter(r5, r10);
    }

    public ConcatAdapter(@NonNull List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r5) {
        this(Config.DEFAULT, r5);
    }

    public ConcatAdapter(@NonNull Config r5, @NonNull List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r10) {
        this.mController = new ConcatAdapterController(this, r5);
        Iterator<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        addAdapter(r11.next());
        goto L4
    L6:
        super.setHasStableIds(this.mController.hasStableIds());
    }
}
