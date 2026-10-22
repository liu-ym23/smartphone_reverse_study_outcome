package com.larus.drive.biz.impl.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.databinding.LarusDriveFileItemBinding;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.biz.impl.view.t;
import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.sdk.api.IDriveSdkService;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import k79.b;
import k79.c;
import k79.d;
import k79.e;
import k79.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0001\"\u0018\u0000 D2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004DEFGBo\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0018J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0006\u0010*\u001a\u00020\tJ\u0006\u0010+\u001a\u00020\tJ\u0006\u0010,\u001a\u00020\tJ\u0010\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0015H\u0002J\u000e\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u000bJ\u0014\u00101\u001a\u00020\t2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00180\u001fJ\u0018\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u001aH\u0016J\u0010\u0010;\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u001aH\u0016J\u0010\u0010<\u001a\u00020\t2\u0006\u00108\u001a\u00020\u0003H\u0016J\b\u0010=\u001a\u00020\tH\u0002J\u0010\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u0018H\u0002J\u0018\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010B\u001a\u00020)H\u0016J\u0010\u0010C\u001a\u00020)2\u0006\u0010(\u001a\u00020)H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#¨\u0006H"}, d2 = {"Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewModel", "Lcom/larus/drive/biz/impl/viewmodel/AbsDriveListViewModel;", "onFileClick", "Lkotlin/Function2;", "Landroid/view/View;", "", "onFileLongClick", "", "isDialogMode", "showOpenTime", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "eventCallback", "Lcom/larus/drive/biz/impl/adapter/IDriveFileListAdapterEventCallback;", "<init>", "(Lcom/larus/drive/biz/impl/viewmodel/AbsDriveListViewModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZLandroidx/lifecycle/LifecycleOwner;Lcom/larus/drive/biz/impl/adapter/IDriveFileListAdapterEventCallback;)V", "footerState", "Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapterFooterState;", "shownFileTokenList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "attachedRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "eventShowFromParam", "isResumed", "isSelectMode", "selectedTokens", "", "pendingShowList", "scrollListener", "com/larus/drive/biz/impl/adapter/DriveFileListAdapter$scrollListener$1", "Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapter$scrollListener$1;", "setEventShowFromParam", "showFrom", "getItemId", "", "position", "", "showLoadingFooter", "showLoadingFailFooter", "hideLoadingFooter", "setFooterState", "newState", "setSelectMode", "enabled", "setSelectedTokens", "tokens", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "onAttachedToRecyclerView", "recyclerView", "onDetachedFromRecyclerView", "onViewAttachedToWindow", "checkAndReportVisiblePending", "addPendingToken", "token", "reportItemIfNeeded", "item", "getItemCount", "getItemViewType", "Companion", "FileViewHolder", "LoadingViewHolder", "FileDiffCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFileListAdapter extends ListAdapter<DriveFileItem, RecyclerView.ViewHolder> {
    public final AbsDriveListViewModel a;
    public final Function2<DriveFileItem, View, Unit> b;
    public final Function2<DriveFileItem, View, Boolean> c;
    public final boolean d;
    public final boolean e;
    public final LifecycleOwner f;
    public final h g;
    public DriveFileListAdapterFooterState h;
    public final CopyOnWriteArrayList<String> i;
    public RecyclerView j;
    public String k;
    public boolean l;
    public boolean m;
    public Set<String> n;
    public final CopyOnWriteArrayList<String> o;
    public final DriveFileListAdapter$scrollListener$1 p;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapter$FileDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FileDiffCallback extends DiffUtil.ItemCallback<DriveFileItem> {
        public FileDiffCallback() {
        }

        public final boolean areContentsTheSame(Object r2, Object r3) {
            DriveFileItem r4 = (DriveFileItem) r2;
            DriveFileItem r5 = (DriveFileItem) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4, r5);
        }

        public final boolean areItemsTheSame(Object r2, Object r3) {
            DriveFileItem r4 = (DriveFileItem) r2;
            DriveFileItem r5 = (DriveFileItem) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4.b, r5.b);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapter$FileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusDriveFileItemBinding;", "<init>", "(Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapter;Lcom/larus/drive/biz/impl/databinding/LarusDriveFileItemBinding;)V", "bind", "", "fileItem", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class FileViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int c = 0;
        public final LarusDriveFileItemBinding a;
        public final /* synthetic */ DriveFileListAdapter b;

        public FileViewHolder(DriveFileListAdapter r2, LarusDriveFileItemBinding r3) {
            Intrinsics.checkNotNullParameter(r3, "binding");
            this.b = r2;
            super(r3.a);
            this.a = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapter$LoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapter;Landroid/view/View;)V", "bind", "", "state", "Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapterFooterState;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class LoadingViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int b = 0;
        public final /* synthetic */ DriveFileListAdapter a;

        public LoadingViewHolder(DriveFileListAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            this.a = r2;
            super(r3);
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        int r0 = super.getItemCount();
        if (this.h == DriveFileListAdapterFooterState.IDLE) goto L5;
        int r1 = 1;
    L7:
        return r0 + r1;
    L5:
        r1 = 0;
        goto L7
    }

    public final void C0(Set<String> r8) {
        Intrinsics.checkNotNullParameter(r8, "tokens");
        Set<String> r0 = this.n;
        this.n = r8;
        LinkedHashSet r1 = new LinkedHashSet();
        r1.addAll(r0);
        r1.addAll(r8);
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L3:
        boolean r4 = false;
        if (r3.hasNext() == false) goto L10;
        Object r5 = r3.next();
        String r6 = (String) r5;
        if (r0.contains(r6) == r8.contains(r6)) goto L8;
        r4 = true;
    L8:
        if (r4 == false) goto L3;
        r2.add(r5);
        goto L3
    L10:
        Iterator r9 = r2.iterator();
    L12:
        if (r9.hasNext() == false) goto L23;
        String r7 = (String) r9.next();
        Iterator r10 = getCurrentList().iterator();
        int r11 = 0;
    L15:
        if (r10.hasNext() == false) goto L20;
        if (Intrinsics.areEqual(((DriveFileItem) r10.next()).b, r7) == true) goto L21;
        r11 = r11 + 1;
    L21:
        if (r11 < 0) goto L12;
        notifyItemChanged(r11);
        goto L12
    L20:
        r11 = -1;
        goto L21
    }

    public final long getItemId(int r4) {
        int r0 = super.getItemCount();
        if (this.h == DriveFileListAdapterFooterState.IDLE) goto L15;
        if (r4 != r0) goto L15;
        return j0.G2_OTA_RECOVERY_BLOCK_FOREVER;
    L15:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r5 = Result.constructor-impl(Long.valueOf(((DriveFileItem) getItem(r4)).b.hashCode()));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r5) == false) goto L14;
        r5 = -1L;
    L14:
        return ((Number) r5).longValue();
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final int getItemViewType(int r4) {
        int r0 = super.getItemCount();
        if (this.h == DriveFileListAdapterFooterState.IDLE) goto L6;
        if (r4 != r0) goto L6;
        return 1;
    L6:
        return 0;
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onAttachedToRecyclerView(r2);
        this.j = r2;
        r2.addOnScrollListener(this.p);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onDetachedFromRecyclerView(r2);
        if (this.j != r2) goto L5;
        this.j = null;
    L5:
        r2.removeOnScrollListener(this.p);
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r7) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewAttachedToWindow(r7);
        int r8 = r7.getBindingAdapterPosition();
        if (r8 != (-1)) goto L6;
        return;
    L6:
        if (getItemViewType(r8) == 0) goto L53;
        return;
    L53:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        Object r2 = Result.constructor-impl((DriveFileItem) getItem(r8));     // Catch: Throwable -> L10
    L12:
        LinearLayoutManager r3 = null;
        if (Result.isFailure-impl(r2) == false) goto L15;
        r2 = null;
    L15:
        DriveFileItem r4 = (DriveFileItem) r2;
        if (r4 != null) goto L18;
        return;
    L18:
        String r5 = r4.b;
        if (StringsKt.isBlank(r5) == false) goto L21;
        return;
    L21:
        RecyclerView r6 = this.j;
        if (r6 != null) goto L24;
        return;
    L24:
        RecyclerView.LayoutManager r9 = r6.getLayoutManager();
        if ((r9 instanceof LinearLayoutManager) == false) goto L27;
        r3 = (LinearLayoutManager) r9;
    L27:
        if (r3 != null) goto L29;
        return;
    L29:
        int r10 = r3.findFirstVisibleItemPosition();
        int r11 = r3.findLastVisibleItemPosition();
        if (r10 == (-1)) goto L50;
        if (r11 == (-1)) goto L50;
        if (this.l == false) goto L36;
        if (r10 > r8) goto L42;
        if (r8 > r11) goto L42;
        boolean r0 = true;
    L43:
        if (r0 == false) goto L46;
        y2(r4, r8);
        return;
    L46:
        if (this.o.contains(r5) == true) goto L57;
        this.o.add(r5);
        return;
    L57:
        return;
    L42:
        r0 = false;
        goto L43
    L36:
        if (this.o.contains(r5) == true) goto L55;
        this.o.add(r5);
        return;
    L55:
        return;
    L50:
        if (this.o.contains(r5) == true) goto L58;
        this.o.add(r5);
        return;
    L58:
        return;
    L10:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void t0(boolean r2) {
        if (this.m != r2) goto L5;
        return;
    L5:
        this.m = r2;
        int r3 = super.getItemCount();
        if (r3 <= 0) goto L9;
        notifyItemRangeChanged(0, r3);
        return;
    }

    public final void z2(DriveFileListAdapterFooterState r6) {
        int r0 = super.getItemCount();
        DriveFileListAdapterFooterState r1 = this.h;
        DriveFileListAdapterFooterState r2 = DriveFileListAdapterFooterState.IDLE;
        boolean r3 = true;
        if (r1 == r2) goto L5;
        boolean r4 = true;
    L6:
        if (r6 != r2) goto L9;
        r3 = false;
    L9:
        this.h = r6;
        if (r4 == false) goto L13;
        if (r3 == false) goto L13;
        notifyItemChanged(r0);
        return;
    L13:
        if (r4 == true) goto L16;
        if (r3 == false) goto L16;
        notifyItemInserted(r0);
        return;
    L16:
        if (r4 == false) goto L21;
        notifyItemRemoved(r0);
        return;
    L21:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "holder");
        int r1 = 8;
        boolean r3 = false;
        if (getItemViewType(r14) == 1) goto L5;
        final DriveFileItem r15 = (DriveFileItem) getItem(r14);
        if ((r13 instanceof FileViewHolder) == false) goto L31;
        final FileViewHolder r16 = (FileViewHolder) r13;
    L32:
        if (r16 == null) goto L75;
        Intrinsics.checkNotNull(r15);
        Intrinsics.checkNotNullParameter(r15, "fileItem");
        FLogger.a.d("DriveFileListAdapter", "Binding file: " + r15.a);
        DriveSdkService r0 = DriveSdkService.a;
        r0.F(r15, r16.a.b);
        if (r15.j != DriveFileType.IMAGE) goto L38;
        if (r15.h() == false) goto L38;
    L40:
        if (r15.j != DriveFileType.VIDEO) goto L42;
        boolean r5 = true;
    L43:
        if (r5 == false) goto L45;
        int r6 = 360;
    L46:
        String r2 = IDriveSdkService.a.b(r0, r15.b, r6, r6);
        if (r2 != null) goto L49;
        e1.q(r16.a.c);
        e1.x(r16.a.b);
    L51:
        TextView r4 = r16.a.e;
        if (StringsKt.isBlank(r15.a) == true) goto L54;
    L56:
        String r7 = r15.a;
    L57:
        r4.setText(r7);
        LarusDriveFileItemBinding r8 = r16.a;
        TextView r9 = r8.f;
        if (r16.b.e == false) goto L60;
        String r10 = StringsKt.replace$default(r8.a.getContext().getString(2131905307), "%s", r16.b.a.formatFileTime(r15.f), false, 4, null);
    L61:
        r9.setText(r10);
        View r11 = r16.a.d;
        DriveFileListAdapter r12 = r16.b;
        if (r12.m == false) goto L64;
        r1 = 0;
    L64:
        r11.setVisibility(r1);
        if (r12.m == true) goto L67;
    L69:
        r11.setSelected(r3);
        View r17 = ((RecyclerView.ViewHolder) r16).itemView;
        final DriveFileListAdapter r18 = r16.b;
        e1.d(r17, new c(r15, r18, r16));
        View r20 = ((RecyclerView.ViewHolder) r16).itemView;
        final DriveFileListAdapter r110 = r16.b;
        r20.setOnLongClickListener(new d(r15, r110));
        return;
    L67:
        if (r12.n.contains(r15.b) == false) goto L69;
        r3 = true;
        goto L69
    L60:
        r10 = StringsKt.replace$default(r8.a.getContext().getString(2131905306), "%s", r16.b.a.formatFileTime(r15.g), false, 4, null);
        goto L61
    L54:
        if (CollectionsKt.listOf(new DriveFileType[]{DriveFileType.AI_DOC, DriveFileType.AI_SLIDES}).contains(r15.j) == false) goto L56;
        r7 = AppHost.a.getApplication().getString(2131905335);
        goto L57
    L49:
        e1.x(r16.a.c);
        e1.q(r16.a.b);
        ImageLoaderKt.v(r16.a.c, r2, "DriveFileListAdapter", null, new b(r16));
        goto L51
    L45:
        r6 = 120;
        goto L46
    L42:
        r5 = false;
    L38:
        if (r15.j == DriveFileType.VIDEO) goto L40;
        e1.q(r16.a.c);
        e1.x(r16.a.b);
        goto L51
    L75:
        return;
    L31:
        r16 = null;
        goto L32
    L5:
        if ((r13 instanceof LoadingViewHolder) == false) goto L7;
        LoadingViewHolder r111 = (LoadingViewHolder) r13;
    L8:
        if (r111 == null) goto L71;
        DriveFileListAdapterFooterState r112 = this.h;
        Intrinsics.checkNotNullParameter(r112, "state");
        View r21 = ((RecyclerView.ViewHolder) r111).itemView.findViewById(2131377292);
        View r22 = ((RecyclerView.ViewHolder) r111).itemView.findViewById(2131377290);
        if (r21 != null) goto L12;
    L16:
        if (r22 == null) goto L22;
        if (r112 != DriveFileListAdapterFooterState.FAIL) goto L20;
        r1 = 0;
    L20:
        r22.setVisibility(r1);
    L22:
        if (r112 != DriveFileListAdapterFooterState.FAIL) goto L25;
        if (r22 == null) goto L72;
        final DriveFileListAdapter r113 = r111.a;
        e1.d(r22, new e(r113));
        return;
    L72:
        return;
    L25:
        if (r22 == null) goto L74;
        r22.setOnClickListener(null);
        return;
    L74:
        return;
    L12:
        if (r112 != DriveFileListAdapterFooterState.LOADING) goto L14;
        int r23 = 0;
    L15:
        r21.setVisibility(r23);
        goto L16
    L14:
        r23 = 8;
        goto L15
    L71:
        return;
    L7:
        r111 = null;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        if (r11 != 0) goto L21;
        View r12 = LayoutInflater.from(r10.getContext()).inflate(2131562321, r10, false);
        int r0 = 2131377278;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r12, 2131377278);
        if (r4 == null) goto L20;
        r0 = 2131377279;
        if (ViewBindings.findChildViewById(r12, 2131377279) == null) goto L20;
        r0 = 2131377281;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r12, 2131377281);
        if (r5 == null) goto L20;
        r0 = 2131377286;
        View r6 = ViewBindings.findChildViewById(r12, 2131377286);
        if (r6 == null) goto L20;
        r0 = 2131377287;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r12, 2131377287);
        if (r7 == null) goto L20;
        r0 = 2131377288;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r12, 2131377288);
        if (r8 == null) goto L20;
        FrameLayout r13 = (FrameLayout) r12;
        FileViewHolder r1 = new FileViewHolder(this, new LarusDriveFileItemBinding(r13, r4, r5, r6, r7, r8));
        if (this.d == false) goto L23;
        r13.setBackground(ContextCompat.getDrawable(r10.getContext(), 2131240683));
        return r1;
    L23:
        return r1;
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    L21:
        View r14 = LayoutInflater.from(r10.getContext()).inflate(2131562323, r10, false);
        Intrinsics.checkNotNull(r14);
        return new LoadingViewHolder(this, r14);
    }

    public final void y2(DriveFileItem r3, int r4) {
        String r0 = r3.b;
        if (StringsKt.isBlank(r0) == false) goto L6;
        return;
    L6:
        if (this.i.contains(r0) == false) goto L8;
        return;
    L8:
        this.i.add(r0);
        this.o.remove(r0);
        h r1 = this.g;
        if (r1 == null) goto L12;
        r1.b(r3, r4, this.k);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.larus.drive.biz.impl.adapter.DriveFileListAdapter$scrollListener$1] */
    public DriveFileListAdapter(AbsDriveListViewModel r2, com.larus.drive.biz.impl.view.b r3, com.larus.drive.biz.impl.view.c r4, boolean r5, boolean r6, LifecycleOwner r7, t r8) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "onFileClick");
        Intrinsics.checkNotNullParameter(r4, "onFileLongClick");
        super(new FileDiffCallback());
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = DriveFileListAdapterFooterState.IDLE;
        this.i = new CopyOnWriteArrayList();
        this.n = SetsKt.emptySet();
        this.o = new CopyOnWriteArrayList();
        this.p = new DriveFileListAdapter$scrollListener$1(this);
        setHasStableIds(true);
        if (r7 == null) goto L8;
        Lifecycle r9 = r7.getLifecycle();
        if (r9 == null) goto L9;
        r9.addObserver(new AnonymousClass1(this));
        return;
    L9:
        return;
    }
}
