package com.ss.android.lark.filedetail.impl.folder.manage.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u0019\u001a\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\tR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FilePreviewInfo;", "<init>", "()V", "listener", "Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter$OnItemSelectListener;", "layoutType", BuildConfig.FLAVOR, "binderFactory", "Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/AdapterBinderFactory;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "position", "onBindViewHolder", BuildConfig.FLAVOR, "holder", "setListener", "setLayoutViewType", IPortraitService.TYPE, "getLayoutViewType", "Companion", "FileItemViewHolder", "ListFileItemViewHolder", "OnItemSelectListener", "FileLayoutType", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileInfoAdapter extends LarkRecyclerViewBaseAdapter<RecyclerView.ViewHolder, nfb.a> {
    public b a;
    public int b;
    public final AdapterBinderFactory c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter$FileItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "fileIcon", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "getFileIcon", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "fileTitle", "Landroid/widget/TextView;", "getFileTitle", "()Landroid/widget/TextView;", "fileSubtitle", "getFileSubtitle", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class FileItemViewHolder extends RecyclerView.ViewHolder {
        public final LKUIRoundedImageView2 a;
        public final TextView b;
        public final TextView c;

        public FileItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131372408);
            this.b = (TextView) r2.findViewById(2131372458);
            this.c = (TextView) r2.findViewById(2131372454);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter$FileLayoutType;", BuildConfig.FLAVOR, "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FileLayoutType {
        public static final a Companion = null;
        public static final int GRID_VIEW = 1;
        public static final int LIST_VIEW = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter$ListFileItemViewHolder;", "Lcom/ss/android/lark/filedetail/impl/folder/manage/adapter/FileInfoAdapter$FileItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "videoPlayIcon", "Landroid/widget/ImageView;", "getVideoPlayIcon", "()Landroid/widget/ImageView;", "videoBg", "getVideoBg", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ListFileItemViewHolder extends FileItemViewHolder {
        public final ImageView d;
        public final ImageView e;

        public ListFileItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.d = (ImageView) r2.findViewById(2131382984);
            this.e = (ImageView) r2.findViewById(2131382979);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(nfb.a r1);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ FileInfoAdapter a;
        public final /* synthetic */ nfb.a b;

        public c(FileInfoAdapter r1, nfb.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            b r3 = this.a.a;
            if (r3 == null) goto L5;
            nfb.a r0 = this.b;
            Intrinsics.checkNotNull(r0);
            r3.a(r0);
            return;
        L5:
            Log.i("FileInfoAdapter", "listener is null");
        }
    }

    static {
    }

    public FileInfoAdapter() {
        this.c = new AdapterBinderFactory();
    }

    public final int getItemViewType(int r1) {
        return this.b;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        nfb.a r5 = (nfb.a) getItem(r4);
        int r0 = this.b;
        Object r1 = (com.ss.android.lark.filedetail.impl.folder.manage.adapter.b) ((Map) this.c.a.getValue()).get(Integer.valueOf(r0));
        if (r1 != null) goto L6;
        r1 = new jfb.c();
    L6:
        if ((r1 instanceof jfb.c) == false) goto L11;
        if ((r3 instanceof ListFileItemViewHolder) == false) goto L11;
        Intrinsics.checkNotNull(r5);
        ((jfb.c) r1).e((FileItemViewHolder) r3, r5);
    L15:
        r3.itemView.setOnClickListener(new c(this, r5));
        return;
    L11:
        if ((r1 instanceof jfb.b) == false) goto L15;
        if ((r3 instanceof FileItemViewHolder) == false) goto L15;
        Intrinsics.checkNotNull(r5);
        ((jfb.b) r1).e((FileItemViewHolder) r3, r5);
        goto L15
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        com.ss.android.lark.filedetail.impl.folder.manage.adapter.b r4 = (com.ss.android.lark.filedetail.impl.folder.manage.adapter.b) ((Map) this.c.a.getValue()).get(Integer.valueOf(r3));
        if (r4 != null) goto L6;
        r4 = new jfb.c();
    L6:
        return r4.a(r2);
    }
}
