package up9;

import androidx.lifecycle.MutableLiveData;
import com.larus.photopicker.v2.impl.MediaSelectorListFragment;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.ui.ClickType;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaMobViewModel;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k0 extends up9.a {
    public final BottomSheetViewModel d;
    public final MediaGalleryLiveDataViewModel e;
    public final MediaMobViewModel f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ClickType.values().length];
            r0[ClickType.ITEM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ClickType.SELECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // up9.a, up9.g0.b
    public final void a(op9.d r4, int r5, ClickType r6) {
        Intrinsics.checkNotNullParameter(r4, "mediaItem");
        Intrinsics.checkNotNullParameter(r6, "type");
        super.a(r4, r5, r6);
        int r7 = a.a[r6.ordinal()];
        boolean r0 = true;
        if (r7 != 1) goto L5;
        BottomSheetViewModel r8 = this.d;
        if (r8 == null) goto L37;
        MutableLiveData<Integer> r9 = r8.getBottomSheetOnStateChanged();
        if (r9 == null) goto L37;
        Integer r10 = (Integer) r9.getValue();
        if (r10 == null) goto L37;
        if (r10.intValue() != 3) goto L37;
        boolean r11 = true;
    L38:
        if (r11 == false) goto L42;
        MediaGalleryLiveDataViewModel r12 = this.e;
        if (r12 == null) goto L78;
        r12.enterPreviewMediaPage(r4, r5);
    L78:
        MediaMobViewModel r13 = this.f;
        if (r13 == null) goto L87;
        r13.mobClickItemInMultipleMode(r4);
        return;
    L87:
        return;
    L42:
        MediaGalleryLiveDataViewModel r14 = this.e;
        if (r14 == null) goto L49;
        MediaGalleryUIConfig r15 = r14.getUiConfig();
        if (r15 == null) goto L49;
        if (r15.p != true) goto L49;
    L50:
        if (r0 == false) goto L63;
        boolean r16 = this.e.getSelectionManager().g(r4.a.a);
        if (r16 == false) goto L54;
    L56:
        this.e.toggleSelection(r4);
        boolean r17 = this.e.getSelectionManager().g(r4.a.a);
        if (r17 == r16) goto L78;
        BottomSheetViewModel r18 = this.d;
        if (r18 == null) goto L78;
        MutableLiveData<Pair<List<op9.d>, Boolean>> r19 = r18.getSelectionMultiConfirmed();
        if (r19 == null) goto L78;
        r19.setValue(TuplesKt.to(CollectionsKt.listOf(r4), Boolean.valueOf(r17)));
        goto L78
    L54:
        if (this.e.getSelectionManager().a(r4) == true) goto L56;
        return;
    L63:
        MediaGalleryLiveDataViewModel r20 = this.e;
        if (r20 != null) goto L66;
    L68:
        BottomSheetViewModel r21 = this.d;
        if (r21 == null) goto L73;
        MutableLiveData<Boolean> r22 = r21.getSelectedResultFromConfirmButton();
        if (r22 == null) goto L73;
        r22.setValue(Boolean.FALSE);
    L73:
        BottomSheetViewModel r23 = this.d;
        if (r23 == null) goto L78;
        MutableLiveData<List<op9.d>> r24 = r23.getSelectedResult();
        if (r24 == null) goto L78;
        r24.setValue(CollectionsKt.listOf(r4));
        goto L78
    L66:
        if (r20.getSelectionManager().a(r4) == true) goto L68;
        return;
    L49:
        r0 = false;
    L37:
        r11 = false;
        goto L38
    L5:
        if (r7 != 2) goto L88;
        MediaGalleryLiveDataViewModel r25 = this.e;
        if (r25 != null) goto L10;
        return;
    L10:
        boolean r26 = r25.getSelectionManager().g(r4.a.a);
        if (r26 == false) goto L13;
    L15:
        MediaMobViewModel r27 = this.f;
        if (r27 == null) goto L18;
        r27.mobClickSelectInMultipleMode$impl_mainlandRelease(r4, r26);
    L18:
        this.e.toggleSelection(r4);
        if (this.e.getUiConfig().p == false) goto L82;
        boolean r28 = this.e.getSelectionManager().g(r4.a.a);
        if (r28 == r26) goto L83;
        BottomSheetViewModel r29 = this.d;
        if (r29 == null) goto L84;
        MutableLiveData<Pair<List<op9.d>, Boolean>> r30 = r29.getSelectionMultiConfirmed();
        if (r30 == null) goto L85;
        r30.setValue(TuplesKt.to(CollectionsKt.listOf(r4), Boolean.valueOf(r28)));
        return;
    L85:
        return;
    L84:
        return;
    L83:
        return;
    L82:
        return;
    L13:
        if (this.e.getSelectionManager().a(r4) == true) goto L15;
        return;
    }

    public k0(MediaSelectorListFragment r2, BottomSheetViewModel r3, MediaGalleryLiveDataViewModel r4, MediaMobViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r4, r5);
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
