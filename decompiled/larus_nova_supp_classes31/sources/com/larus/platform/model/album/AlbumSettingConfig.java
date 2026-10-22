package com.larus.platform.model.album;

import com.larus.platform.model.preview.InputDraftSnapshot;
import com.larus.platform.model.preview.MediaEntry;
import com.larus.platform.service.z2;
import com.tencent.open.log.TraceLevel;
import dr9.g;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 p2\u00020\u0001:\u0002pqB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010k\u001a\u00020\u0005H\u0016J\b\u0010l\u001a\u00020\u0013H\u0016J\u0013\u0010m\u001a\u00020\u000e2\b\u0010n\u001a\u0004\u0018\u00010oH\u0096\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\u001a\u0010'\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u001a\u0010*\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001a\u0010-\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001c\u00100\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011R\u001a\u0010<\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000f\"\u0004\b>\u0010\u0011R\u001e\u0010?\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010D\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u000f\"\u0004\bM\u0010\u0011R\u001a\u0010N\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u000f\"\u0004\bP\u0010\u0011R\u001e\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u0010\n\u0002\u0010W\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010X\u001a\u0004\u0018\u00010YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u000f\"\u0004\b_\u0010\u0011R\u001e\u0010`\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\ba\u0010 \"\u0004\bb\u0010\"R\u001a\u0010c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u000f\"\u0004\be\u0010\u0011R\u001a\u0010f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u000f\"\u0004\bh\u0010\u0011R\u001a\u0010i\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u000f\"\u0004\bj\u0010\u0011¨\u0006r"}, d2 = {"Lcom/larus/platform/model/album/AlbumSettingConfig;", "Ljava/io/Serializable;", "<init>", "()V", "albumNodeId", "", "getAlbumNodeId", "()Ljava/lang/String;", "setAlbumNodeId", "(Ljava/lang/String;)V", "upstreamAlbumNodeId", "getUpstreamAlbumNodeId", "setUpstreamAlbumNodeId", "isMultiPick", "", "()Z", "setMultiPick", "(Z)V", "maxSelectCount", "", "getMaxSelectCount", "()I", "setMaxSelectCount", "(I)V", "spanCount", "getSpanCount", "setSpanCount", "supportVideo", "getSupportVideo", "setSupportVideo", "landingTabIndex", "getLandingTabIndex", "()Ljava/lang/Integer;", "setLandingTabIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "clickFrom", "getClickFrom", "setClickFrom", "onlyDisplayVideo", "getOnlyDisplayVideo", "setOnlyDisplayVideo", "maxSelectVideoCount", "getMaxSelectVideoCount", "setMaxSelectVideoCount", "enableInjectInput", "getEnableInjectInput", "setEnableInjectInput", "suggestedActionProvider", "getSuggestedActionProvider", "setSuggestedActionProvider", "initialInputState", "Lcom/larus/platform/model/album/AlbumInputState;", "getInitialInputState", "()Lcom/larus/platform/model/album/AlbumInputState;", "setInitialInputState", "(Lcom/larus/platform/model/album/AlbumInputState;)V", "allowUnifiedPreview", "getAllowUnifiedPreview", "setAllowUnifiedPreview", "mobilePreviewHostEnabled", "getMobilePreviewHostEnabled", "setMobilePreviewHostEnabled", "useUnifiedMediaCanvas", "getUseUnifiedMediaCanvas", "()Ljava/lang/Boolean;", "setUseUnifiedMediaCanvas", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "unifiedPreviewEntry", "Lcom/larus/platform/model/preview/MediaEntry;", "getUnifiedPreviewEntry", "()Lcom/larus/platform/model/preview/MediaEntry;", "setUnifiedPreviewEntry", "(Lcom/larus/platform/model/preview/MediaEntry;)V", "hideAlbumEntranceInInjectedInput", "getHideAlbumEntranceInInjectedInput", "setHideAlbumEntranceInInjectedInput", "enableSeparateMediaSelection", "getEnableSeparateMediaSelection", "setEnableSeparateMediaSelection", "maxVideoDuration", "", "getMaxVideoDuration", "()Ljava/lang/Long;", "setMaxVideoDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "creationReferenceConfig", "Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "getCreationReferenceConfig", "()Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "setCreationReferenceConfig", "(Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;)V", "isUseSingleDefault", "setUseSingleDefault", "startNavigationBarColor", "getStartNavigationBarColor", "setStartNavigationBarColor", "enableMultiSelectConfirmed", "getEnableMultiSelectConfirmed", "setEnableMultiSelectConfirmed", "supportOriginalImage", "getSupportOriginalImage", "setSupportOriginalImage", "isCreationScene", "setCreationScene", "toString", "hashCode", "equals", "other", "", "Companion", "Builder", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AlbumSettingConfig implements Serializable {
    public static final b Companion = null;
    private String albumNodeId;
    private boolean allowUnifiedPreview;
    private String clickFrom;
    private CreationReferenceAlbumConfig creationReferenceConfig;
    private boolean enableInjectInput;
    private boolean enableMultiSelectConfirmed;
    private boolean enableSeparateMediaSelection;
    private boolean hideAlbumEntranceInInjectedInput;
    private AlbumInputState initialInputState;
    private boolean isCreationScene;
    private boolean isMultiPick;
    private boolean isUseSingleDefault;
    private Integer landingTabIndex;
    private int maxSelectCount;
    private int maxSelectVideoCount;
    private Long maxVideoDuration;
    private boolean mobilePreviewHostEnabled;
    private boolean onlyDisplayVideo;
    private int spanCount;
    private Integer startNavigationBarColor;
    private String suggestedActionProvider;
    private boolean supportOriginalImage;
    private boolean supportVideo;
    private MediaEntry unifiedPreviewEntry;
    private String upstreamAlbumNodeId;
    private Boolean useUnifiedMediaCanvas;

    public static final class a {
        public final String a;
        public String b;
        public boolean c;
        public int d;
        public boolean e;
        public String f;
        public Integer g;
        public int h;
        public boolean i;
        public Integer j;
        public boolean k;
        public AlbumInputState l;
        public boolean m;
        public boolean n;
        public Boolean o;
        public MediaEntry p;
        public boolean q;
        public boolean r;
        public boolean s;
        public int t;
        public boolean u;
        public long v;
        public CreationReferenceAlbumConfig w;
        public boolean x;
        public boolean y;

        public final AlbumSettingConfig a() {
            AlbumSettingConfig r0 = new AlbumSettingConfig(null);
            r0.setAlbumNodeId(this.a);
            r0.setUpstreamAlbumNodeId(this.b);
            r0.setMaxSelectCount(this.d);
            r0.setUseSingleDefault(this.e);
            r0.setClickFrom(this.f);
            r0.setStartNavigationBarColor(this.g);
            r0.setSpanCount(this.h);
            r0.setSupportVideo(this.i);
            r0.setLandingTabIndex(this.j);
            r0.setEnableInjectInput(this.k);
            r0.setSuggestedActionProvider(null);
            r0.setInitialInputState(this.l);
            r0.setAllowUnifiedPreview(this.m);
            r0.setMobilePreviewHostEnabled(this.n);
            r0.setUseUnifiedMediaCanvas(this.o);
            r0.setUnifiedPreviewEntry(this.p);
            r0.setHideAlbumEntranceInInjectedInput(this.q);
            r0.setOnlyDisplayVideo(this.r);
            r0.setEnableSeparateMediaSelection(this.s);
            r0.setMaxSelectVideoCount(this.t);
            r0.setMultiPick(this.c);
            r0.setEnableMultiSelectConfirmed(this.u);
            r0.setMaxVideoDuration(Long.valueOf(this.v));
            r0.setCreationReferenceConfig(this.w);
            r0.setSupportOriginalImage(this.x);
            r0.setCreationScene(this.y);
            return r0;
        }

        public a() {
            Map<String, Integer> r0 = kq9.b.a;
            this.a = g.e("album-node");
            this.b = "";
            this.d = 1;
            this.h = z2.a.n1().c;
            this.j = 0;
            this.t = -1;
        }

        public final void b(AlbumInputState r11) {
            AlbumInputState r0 = null;
            String r1 = null;
            if (r11 != null) goto L5;
        L27:
            this.l = r0;
            return;
        L5:
            if (r11.getAttachments().isEmpty() == true) goto L26;
            String r2 = r11.getInputSnapshotId();
            if (r2 == null) goto L24;
            g r3 = g.a;
            InputDraftSnapshot r4 = g.d(r2);
            boolean r5 = false;
            if (r4 != null) goto L12;
        L21:
            if (r5 == false) goto L23;
            r1 = r2;
        L23:
            if (r1 == null) goto L24;
        L25:
            List r6 = CollectionsKt.emptyList();
            r11 = AlbumInputState.copy$default(r11, null, r6, null, r1, null, 21, null);
            goto L26
        L12:
            if (Intrinsics.areEqual(r4.getText(), r11.getText()) == true) goto L14;
        L18:
            boolean r7 = false;
        L19:
            if (r7 != true) goto L21;
            r5 = true;
            goto L21
        L14:
            if (Intrinsics.areEqual(r4.getSourceNodeId(), r11.getSourceNodeId()) == false) goto L18;
            if (Intrinsics.areEqual(r4.getAttachments(), r11.getAttachments()) == false) goto L18;
            r7 = true;
        L24:
            r1 = g.a.b(new InputDraftSnapshot(r11.getText(), r11.getAttachments(), r11.getSourceNodeId(), 0, 8, null));
        L26:
            r0 = r11;
            goto L27
        }

        public final void c(MediaEntry r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            this.p = r2;
        }
    }

    public static final class b {
        public static AlbumSettingConfig a() {
            return new a().a();
        }

        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public /* synthetic */ AlbumSettingConfig(DefaultConstructorMarker r1) {
        this();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("isMultiPick=");
        r0.append(this.isMultiPick);
        r0.append(", maxSelectCount=");
        r0.append(this.maxSelectCount);
        r0.append(", isUseSingleDefault=");
        r0.append(this.isUseSingleDefault);
        r0.append(", clickFrom=");
        r0.append(this.clickFrom);
        r0.append(", startNavigationBarColor=");
        r0.append(this.startNavigationBarColor);
        r0.append(", spanCount=");
        r0.append(this.spanCount);
        r0.append(", supportVideo=");
        r0.append(this.supportVideo);
        r0.append(", landingTabIndex=");
        r0.append(this.landingTabIndex);
        r0.append(", enableInput=");
        r0.append(this.enableInjectInput);
        r0.append(", suggestedActionProvider=");
        r0.append(this.suggestedActionProvider);
        r0.append(", initialInputStateHash=");
        AlbumInputState r1 = this.initialInputState;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.hashCode());
    L6:
        r0.append(r2);
        r0.append(", allowUnifiedPreview=");
        r0.append(this.allowUnifiedPreview);
        r0.append(", hideAlbumEntranceInInjectedInput=");
        r0.append(this.hideAlbumEntranceInInjectedInput);
        r0.append(", onlyDisplayVideo=");
        r0.append(this.onlyDisplayVideo);
        r0.append(", enableSeparateMediaSelection=");
        r0.append(this.enableSeparateMediaSelection);
        r0.append(", maxSelectVideoCount=");
        r0.append(this.maxSelectVideoCount);
        r0.append(", maxVideoDuration=");
        r0.append(this.maxVideoDuration);
        r0.append(", isCreationScene=");
        r0.append(this.isCreationScene);
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    private AlbumSettingConfig() {
        Map<String, Integer> r0 = kq9.b.a;
        this.albumNodeId = g.e("album-node");
        this.upstreamAlbumNodeId = "";
        this.maxSelectCount = 1;
        this.spanCount = 4;
        this.landingTabIndex = 0;
        this.maxSelectVideoCount = -1;
        this.maxVideoDuration = 0L;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final String getAlbumNodeId() {
        return this.albumNodeId;
    }

    public final boolean getAllowUnifiedPreview() {
        return this.allowUnifiedPreview;
    }

    public final String getClickFrom() {
        return this.clickFrom;
    }

    public final CreationReferenceAlbumConfig getCreationReferenceConfig() {
        return this.creationReferenceConfig;
    }

    public final boolean getEnableInjectInput() {
        return this.enableInjectInput;
    }

    public final boolean getEnableMultiSelectConfirmed() {
        return this.enableMultiSelectConfirmed;
    }

    public final boolean getEnableSeparateMediaSelection() {
        return this.enableSeparateMediaSelection;
    }

    public final boolean getHideAlbumEntranceInInjectedInput() {
        return this.hideAlbumEntranceInInjectedInput;
    }

    public final AlbumInputState getInitialInputState() {
        return this.initialInputState;
    }

    public final Integer getLandingTabIndex() {
        return this.landingTabIndex;
    }

    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    public final int getMaxSelectVideoCount() {
        return this.maxSelectVideoCount;
    }

    public final Long getMaxVideoDuration() {
        return this.maxVideoDuration;
    }

    public final boolean getMobilePreviewHostEnabled() {
        return this.mobilePreviewHostEnabled;
    }

    public final boolean getOnlyDisplayVideo() {
        return this.onlyDisplayVideo;
    }

    public final int getSpanCount() {
        return this.spanCount;
    }

    public final Integer getStartNavigationBarColor() {
        return this.startNavigationBarColor;
    }

    public final String getSuggestedActionProvider() {
        return this.suggestedActionProvider;
    }

    public final boolean getSupportOriginalImage() {
        return this.supportOriginalImage;
    }

    public final boolean getSupportVideo() {
        return this.supportVideo;
    }

    public final MediaEntry getUnifiedPreviewEntry() {
        return this.unifiedPreviewEntry;
    }

    public final String getUpstreamAlbumNodeId() {
        return this.upstreamAlbumNodeId;
    }

    public final Boolean getUseUnifiedMediaCanvas() {
        return this.useUnifiedMediaCanvas;
    }

    public final boolean isCreationScene() {
        return this.isCreationScene;
    }

    public final boolean isMultiPick() {
        return this.isMultiPick;
    }

    public final boolean isUseSingleDefault() {
        return this.isUseSingleDefault;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof AlbumSettingConfig) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(toString(), ((AlbumSettingConfig) r2).toString());
    }

    public final void setAlbumNodeId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.albumNodeId = r2;
    }

    public final void setAllowUnifiedPreview(boolean r1) {
        this.allowUnifiedPreview = r1;
    }

    public final void setClickFrom(String r1) {
        this.clickFrom = r1;
    }

    public final void setCreationReferenceConfig(CreationReferenceAlbumConfig r1) {
        this.creationReferenceConfig = r1;
    }

    public final void setCreationScene(boolean r1) {
        this.isCreationScene = r1;
    }

    public final void setEnableInjectInput(boolean r1) {
        this.enableInjectInput = r1;
    }

    public final void setEnableMultiSelectConfirmed(boolean r1) {
        this.enableMultiSelectConfirmed = r1;
    }

    public final void setEnableSeparateMediaSelection(boolean r1) {
        this.enableSeparateMediaSelection = r1;
    }

    public final void setHideAlbumEntranceInInjectedInput(boolean r1) {
        this.hideAlbumEntranceInInjectedInput = r1;
    }

    public final void setInitialInputState(AlbumInputState r1) {
        this.initialInputState = r1;
    }

    public final void setLandingTabIndex(Integer r1) {
        this.landingTabIndex = r1;
    }

    public final void setMaxSelectCount(int r1) {
        this.maxSelectCount = r1;
    }

    public final void setMaxSelectVideoCount(int r1) {
        this.maxSelectVideoCount = r1;
    }

    public final void setMaxVideoDuration(Long r1) {
        this.maxVideoDuration = r1;
    }

    public final void setMobilePreviewHostEnabled(boolean r1) {
        this.mobilePreviewHostEnabled = r1;
    }

    public final void setMultiPick(boolean r1) {
        this.isMultiPick = r1;
    }

    public final void setOnlyDisplayVideo(boolean r1) {
        this.onlyDisplayVideo = r1;
    }

    public final void setSpanCount(int r1) {
        this.spanCount = r1;
    }

    public final void setStartNavigationBarColor(Integer r1) {
        this.startNavigationBarColor = r1;
    }

    public final void setSuggestedActionProvider(String r1) {
        this.suggestedActionProvider = r1;
    }

    public final void setSupportOriginalImage(boolean r1) {
        this.supportOriginalImage = r1;
    }

    public final void setSupportVideo(boolean r1) {
        this.supportVideo = r1;
    }

    public final void setUnifiedPreviewEntry(MediaEntry r1) {
        this.unifiedPreviewEntry = r1;
    }

    public final void setUpstreamAlbumNodeId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.upstreamAlbumNodeId = r2;
    }

    public final void setUseSingleDefault(boolean r1) {
        this.isUseSingleDefault = r1;
    }

    public final void setUseUnifiedMediaCanvas(Boolean r1) {
        this.useUnifiedMediaCanvas = r1;
    }
}
