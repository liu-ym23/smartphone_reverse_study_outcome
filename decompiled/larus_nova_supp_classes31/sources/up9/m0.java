package up9;

import androidx.lifecycle.MutableLiveData;
import com.larus.photopicker.v2.impl.MediaSelectorListFragment;
import com.larus.photopicker.v2.impl.ui.ClickType;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaMobViewModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m0 extends up9.a {
    public final BottomSheetViewModel d;
    public final MediaGalleryLiveDataViewModel e;
    public final MediaMobViewModel f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ClickType.values().length];
            r0[ClickType.ITEM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    @Override // up9.a, up9.g0.b
    public final void a(op9.d r2, int r3, ClickType r4) {
        Intrinsics.checkNotNullParameter(r2, "mediaItem");
        Intrinsics.checkNotNullParameter(r4, "type");
        super.a(r2, r3, r4);
        if (a.a[r4.ordinal()] != 1) goto L26;
        MediaGalleryLiveDataViewModel r5 = this.e;
        if (r5 == null) goto L27;
        com.larus.photopicker.v2.impl.viewmodel.d r6 = r5.getSelectionManager();
        if (r6 != null) goto L10;
        return;
    L10:
        if (r6.a(r2) == true) goto L12;
        return;
    L12:
        BottomSheetViewModel r7 = this.d;
        if (r7 == null) goto L17;
        MutableLiveData<Boolean> r8 = r7.getSelectedResultFromConfirmButton();
        if (r8 == null) goto L17;
        r8.setValue(Boolean.FALSE);
    L17:
        BottomSheetViewModel r9 = this.d;
        if (r9 == null) goto L22;
        MutableLiveData<List<op9.d>> r10 = r9.getSelectedResult();
        if (r10 == null) goto L22;
        r10.setValue(CollectionsKt.listOf(r2));
    L22:
        MediaMobViewModel r11 = this.f;
        if (r11 == null) goto L28;
        r11.mobClickItemInSingleMode(r2);
        return;
    L28:
        return;
    L27:
        return;
    }

    public m0(MediaSelectorListFragment r2, BottomSheetViewModel r3, MediaGalleryLiveDataViewModel r4, MediaMobViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r4, r5);
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
