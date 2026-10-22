package com.larus.doc.sdk.impl.generalbiz.state.media;

import com.bytedance.ee.bear.api.toolbar.media.impl.SelectedMediaItem;
import com.larus.doc.sdk.impl.generalbiz.common.DocSdkVersion;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xm9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ/\u0010\n\u001a\u00020\u000b2'\u0010\f\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\rJ/\u0010\u0013\u001a\u00020\u000b2'\u0010\f\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\rR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectMediaProcessor;", "", "viewModel", "Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectMediaViewModel;", "docPluginHost", "Lcom/larus/office/base/plugins/IOfficePluginHost;", "docSdkVersion", "Lcom/larus/doc/sdk/impl/generalbiz/common/DocSdkVersion;", "<init>", "(Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectMediaViewModel;Lcom/larus/office/base/plugins/IOfficePluginHost;Lcom/larus/doc/sdk/impl/generalbiz/common/DocSdkVersion;)V", "addMediaSelectCallback", "", "insertAndSwitchToReadOnlyMode", "Lkotlin/Function1;", "", "Lcom/bytedance/ee/bear/api/toolbar/media/impl/SelectedMediaItem;", "Lkotlin/ParameterName;", "name", "media", "addMediaSelectCallbackV1", "Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectedMediaItemV1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectMediaProcessor {
    public static final Companion Companion = null;
    public static final String PLUGIN_TAG = "SelectMediaPlugin";
    private final a docPluginHost;
    private final DocSdkVersion docSdkVersion;
    private final SelectMediaViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectMediaProcessor$Companion;", "", "<init>", "()V", "PLUGIN_TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ a access$getDocPluginHost$p(SelectMediaProcessor r0) {
        return r0.docPluginHost;
    }

    public static final /* synthetic */ DocSdkVersion access$getDocSdkVersion$p(SelectMediaProcessor r0) {
        return r0.docSdkVersion;
    }

    public final void addMediaSelectCallback(final Function1<? super List<? extends SelectedMediaItem>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "insertAndSwitchToReadOnlyMode");
        SelectMediaViewModel r0 = this.viewModel;
        if (r0 == null) goto L6;
        r0.setCallback(new AnonymousClass1(this, r3));
        return;
    }

    public final void addMediaSelectCallbackV1(final Function1<? super List<SelectedMediaItemV1>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "insertAndSwitchToReadOnlyMode");
        SelectMediaViewModel r0 = this.viewModel;
        if (r0 == null) goto L6;
        r0.setCallback(new C01651(this, r3));
        return;
    }

    public SelectMediaProcessor(SelectMediaViewModel r2, a r3, DocSdkVersion r4) {
        Intrinsics.checkNotNullParameter(r3, "docPluginHost");
        Intrinsics.checkNotNullParameter(r4, "docSdkVersion");
        this.viewModel = r2;
        this.docPluginHost = r3;
        this.docSdkVersion = r4;
    }

    public /* synthetic */ SelectMediaProcessor(SelectMediaViewModel r1, a r2, DocSdkVersion r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1, r2, r3);
    }
}
