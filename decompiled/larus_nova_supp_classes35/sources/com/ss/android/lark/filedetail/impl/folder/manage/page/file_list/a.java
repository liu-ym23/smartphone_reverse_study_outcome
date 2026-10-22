package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import android.content.Context;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends BasePresenter<i, j, j.a> {
    public final Context a;
    public final FolderManageLaunchParams b;
    public final AtomicBoolean c;
    public final FileListPresenter$callback$1 d;

    /* JADX INFO: renamed from: com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.a$a, reason: collision with other inner class name */
    public static final class C0207a {
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new b(this);
    }

    public final Context getContext() {
        return this.a;
    }

    public static final /* synthetic */ j H8(a r0) {
        return (j) r0.getView();
    }

    public static final void I8(a r8) {
        if (r8.c.get() == false) goto L22;
        int r0 = pfb.d.a;
        FolderManageLaunchParams r1 = r8.b;
        String r2 = r1.b;
        int r3 = r1.e;
        long r4 = ((i) r8.getModel()).t3();
        if (r2 != null) goto L7;
    L10:
        boolean r6 = true;
    L11:
        if (r6 == false) goto L14;
    L20:
        pfb.d.a.d(r8.b.b, ((i) r8.getModel()).M(), r8.b.e);
        r8.c.set(false);
        return;
    L14:
        if (r3 != 7) goto L16;
    L18:
        String r5 = "file_search_mobile";
    L19:
        pfb.d.a.b(r2, "im_chat_file_manage_view", MapsKt.mapOf(new Pair[]{TuplesKt.to("source", r5), TuplesKt.to("total_item_count", Long.valueOf(r4))}));
        goto L20
    L16:
        if (r3 == 8) goto L18;
        r5 = "none";
        goto L19
    L7:
        if (r2.length() == 0) goto L10;
        r6 = false;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.FileListPresenter$callback$1] */
    public a(Context r4, FileListFragment.a r5, FolderManageLaunchParams r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "dependency");
        Intrinsics.checkNotNullParameter(r6, "params");
        this.a = r4;
        this.b = r6;
        this.c = new AtomicBoolean(true);
        this.d = new FileListPresenter$callback$1(this);
        FileListModel r0 = new FileListModel(r6, ((Number) r5.a().getFirst()).longValue());
        FileListView r1 = new FileListView(r4, r5, r6);
        r1.i = new b(this);
        setModel(r0);
        setView(r1);
    }
}
