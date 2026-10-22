package androidx.recyclerview.widget;

import ai.j0;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
interface ViewTypeStorage {

    public static class IsolatedViewTypeStorage implements ViewTypeStorage {
        SparseArray<NestedAdapterWrapper> mGlobalTypeToWrapper;
        int mNextViewType;

        public class WrapperViewTypeLookup implements ViewTypeLookup {
            private SparseIntArray mGlobalToLocalMapping;
            private SparseIntArray mLocalToGlobalMapping;
            final NestedAdapterWrapper mWrapper;
            final /* synthetic */ IsolatedViewTypeStorage this$0;

            public WrapperViewTypeLookup(IsolatedViewTypeStorage r5, NestedAdapterWrapper r10) {
                this.this$0 = r5;
                this.mLocalToGlobalMapping = new SparseIntArray(1);
                this.mGlobalToLocalMapping = new SparseIntArray(1);
                this.mWrapper = r10;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public void dispose() {
                this.this$0.removeWrapper(this.mWrapper);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int globalToLocal(int r5) {
                int r10 = this.mGlobalToLocalMapping.indexOfKey(r5);
                if (r10 >= 0) goto L5;
                StringBuilder r11 = j0.s(r5, "requested global type ", " does not belong to the adapter:");
                r11.append(this.mWrapper.adapter);
                throw new IllegalStateException(r11.toString());
            L5:
                return this.mGlobalToLocalMapping.valueAt(r10);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int localToGlobal(int r5) {
                int r10 = this.mLocalToGlobalMapping.indexOfKey(r5);
                if (r10 > (-1)) goto L5;
                int r11 = this.this$0.obtainViewType(this.mWrapper);
                this.mLocalToGlobalMapping.put(r5, r11);
                this.mGlobalToLocalMapping.put(r11, r5);
                return r11;
            L5:
                return this.mLocalToGlobalMapping.valueAt(r10);
            }
        }

        public IsolatedViewTypeStorage() {
            this.mGlobalTypeToWrapper = new SparseArray();
            this.mNextViewType = 0;
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        @NonNull
        public ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper r5) {
            return new WrapperViewTypeLookup(this, r5);
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        @NonNull
        public NestedAdapterWrapper getWrapperForGlobalType(int r5) {
            NestedAdapterWrapper r10 = this.mGlobalTypeToWrapper.get(r5);
            if (r10 == null) goto L6;
            return r10;
        L6:
            throw new IllegalArgumentException(j0.g(r5, "Cannot find the wrapper for global view type "));
        }

        public int obtainViewType(NestedAdapterWrapper r5) {
            int r10 = this.mNextViewType;
            this.mNextViewType = r10 + 1;
            this.mGlobalTypeToWrapper.put(r10, r5);
            return r10;
        }

        public void removeWrapper(@NonNull NestedAdapterWrapper r5) {
            int r10 = this.mGlobalTypeToWrapper.size() - 1;
        L3:
            if (r10 < 0) goto L8;
            if (this.mGlobalTypeToWrapper.valueAt(r10) != r5) goto L7;
            this.mGlobalTypeToWrapper.removeAt(r10);
        L7:
            r10 = r10 - 1;
            goto L3
        }
    }

    public static class SharedIdRangeViewTypeStorage implements ViewTypeStorage {
        SparseArray<List<NestedAdapterWrapper>> mGlobalTypeToWrapper;

        public class WrapperViewTypeLookup implements ViewTypeLookup {
            final NestedAdapterWrapper mWrapper;
            final /* synthetic */ SharedIdRangeViewTypeStorage this$0;

            public WrapperViewTypeLookup(SharedIdRangeViewTypeStorage r5, NestedAdapterWrapper r10) {
                this.this$0 = r5;
                this.mWrapper = r10;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public void dispose() {
                this.this$0.removeWrapper(this.mWrapper);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int globalToLocal(int r5) {
                return r5;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int localToGlobal(int r5) {
                List<NestedAdapterWrapper> r10 = this.this$0.mGlobalTypeToWrapper.get(r5);
                if (r10 != null) goto L6;
                r10 = new ArrayList();
                this.this$0.mGlobalTypeToWrapper.put(r5, r10);
            L6:
                if (r10.contains(this.mWrapper) == true) goto L8;
                r10.add(this.mWrapper);
            L8:
                return r5;
            }
        }

        public SharedIdRangeViewTypeStorage() {
            this.mGlobalTypeToWrapper = new SparseArray();
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        @NonNull
        public ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper r5) {
            return new WrapperViewTypeLookup(this, r5);
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        @NonNull
        public NestedAdapterWrapper getWrapperForGlobalType(int r5) {
            List<NestedAdapterWrapper> r10 = this.mGlobalTypeToWrapper.get(r5);
            if (r10 == null) goto L9;
            if (r10.isEmpty() == true) goto L9;
            return r10.get(0);
        L9:
            throw new IllegalArgumentException(j0.g(r5, "Cannot find the wrapper for global view type "));
        }

        public void removeWrapper(@NonNull NestedAdapterWrapper r5) {
            int r10 = this.mGlobalTypeToWrapper.size() - 1;
        L3:
            if (r10 < 0) goto L10;
            List<NestedAdapterWrapper> r11 = this.mGlobalTypeToWrapper.valueAt(r10);
            if (r11.remove(r5) == false) goto L9;
            if (r11.isEmpty() == false) goto L9;
            this.mGlobalTypeToWrapper.removeAt(r10);
        L9:
            r10 = r10 - 1;
            goto L3
        }
    }

    public interface ViewTypeLookup {
        void dispose();

        int globalToLocal(int r5);

        int localToGlobal(int r5);
    }

    @NonNull
    ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper r5);

    @NonNull
    NestedAdapterWrapper getWrapperForGlobalType(int r5);
}
