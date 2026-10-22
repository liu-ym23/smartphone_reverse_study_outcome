package com.larus.photopicker.v2.impl.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.preview.MediaEntry;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\bT\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u0080\u00012\u00020\u0001:\u0004\u0080\u0001\u0081\u0001BÇ\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\r\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\b\b\u0002\u0010 \u001a\u00020\t\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\t\u0012\b\b\u0002\u0010&\u001a\u00020\t\u0012\b\b\u0002\u0010'\u001a\u00020\t\u0012\b\b\u0002\u0010(\u001a\u00020\u0006¢\u0006\u0004\b)\u0010*J\b\u0010S\u001a\u00020\rH\u0016J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0006HÆ\u0003J\t\u0010V\u001a\u00020\u0006HÆ\u0003J\t\u0010W\u001a\u00020\tHÆ\u0003J\t\u0010X\u001a\u00020\u000bHÆ\u0003J\t\u0010Y\u001a\u00020\rHÆ\u0003J\t\u0010Z\u001a\u00020\tHÆ\u0003J\t\u0010[\u001a\u00020\u0006HÆ\u0003J\t\u0010\\\u001a\u00020\u0006HÆ\u0003J\t\u0010]\u001a\u00020\u0006HÆ\u0003J\t\u0010^\u001a\u00020\u0006HÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010`\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010:J\t\u0010a\u001a\u00020\u0006HÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010:J\t\u0010c\u001a\u00020\tHÆ\u0003J\t\u0010d\u001a\u00020\tHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010h\u001a\u00020\rHÆ\u0003J\u000f\u0010i\u001a\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0003J\t\u0010j\u001a\u00020\rHÆ\u0003J\t\u0010k\u001a\u00020\rHÆ\u0003J\t\u0010l\u001a\u00020\tHÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010JJ\t\u0010n\u001a\u00020\tHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010$HÆ\u0003J\t\u0010p\u001a\u00020\tHÆ\u0003J\t\u0010q\u001a\u00020\tHÆ\u0003J\t\u0010r\u001a\u00020\tHÆ\u0003J\t\u0010s\u001a\u00020\u0006HÆ\u0003Jê\u0002\u0010t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\t2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\"\u001a\u00020\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\t2\b\b\u0002\u0010&\u001a\u00020\t2\b\b\u0002\u0010'\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010uJ\u0006\u0010v\u001a\u00020\u0006J\u0013\u0010w\u001a\u00020\t2\b\u0010x\u001a\u0004\u0018\u00010yHÖ\u0003J\t\u0010z\u001a\u00020\u0006HÖ\u0001J\u0016\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u00100R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u00100R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u0010.R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u0010.R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u0010.R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010;\u001a\u0004\b<\u0010:R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u0010.R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010;\u001a\u0004\b>\u0010:R\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b?\u00100R\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b@\u00100R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bA\u00104R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bB\u00104R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bC\u00104R\u0011\u0010\u001c\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bD\u00104R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010,R\u0011\u0010\u001e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bF\u00104R\u0011\u0010\u001f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bG\u00104R\u0011\u0010 \u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bH\u00100R\u0015\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010K\u001a\u0004\bI\u0010JR\u0011\u0010\"\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bL\u00100R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0011\u0010%\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bO\u00100R\u0011\u0010&\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bP\u00100R\u0011\u0010'\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bQ\u00100R\u0011\u0010(\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bR\u0010.¨\u0006\u0082\u0001"}, d2 = {"Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;", "Landroid/os/Parcelable;", "tabs", "", "Lcom/larus/photopicker/v2/impl/model/MediaTab;", "spanCount", "", "maxSelectedCount", "isSingleSelectionMode", "", "mode", "Lcom/larus/platform/model/MediaPickerUIMode;", "displayType", "", "isSupportVideo", "bottomMenuInitHeight", "bottomMenuTotalHeight", "startNavigationBarColor", "defaultItemDecorationSpacing", "slideBottomItemDecorationSpacing", "slideUpItemDecorationSpacing", "defaultPaddingSpacing", "slideUpPaddingSpacing", "multiSelectConfirmed", "supportInput", "suggestedActionProvider", "initialInputText", "initialInputSnapshotId", "initialInputSourceNodeId", "initialAttachmentUris", "albumNodeId", "upstreamAlbumNodeId", "allowUnifiedPreview", "useUnifiedMediaCanvas", "mobilePreviewHostEnabled", "unifiedPreviewEntry", "Lcom/larus/platform/model/preview/MediaEntry;", "hideAlbumEntranceInInjectedInput", "onlyDisplayVideo", "supportOriginalImage", "landingTabIndex", "<init>", "(Ljava/util/List;IIZLcom/larus/platform/model/MediaPickerUIMode;Ljava/lang/String;ZIIIILjava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;ZLcom/larus/platform/model/preview/MediaEntry;ZZZI)V", "getTabs", "()Ljava/util/List;", "getSpanCount", "()I", "getMaxSelectedCount", "()Z", "getMode", "()Lcom/larus/platform/model/MediaPickerUIMode;", "getDisplayType", "()Ljava/lang/String;", "getBottomMenuInitHeight", "getBottomMenuTotalHeight", "getStartNavigationBarColor", "getDefaultItemDecorationSpacing", "getSlideBottomItemDecorationSpacing", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSlideUpItemDecorationSpacing", "getDefaultPaddingSpacing", "getSlideUpPaddingSpacing", "getMultiSelectConfirmed", "getSupportInput", "getSuggestedActionProvider", "getInitialInputText", "getInitialInputSnapshotId", "getInitialInputSourceNodeId", "getInitialAttachmentUris", "getAlbumNodeId", "getUpstreamAlbumNodeId", "getAllowUnifiedPreview", "getUseUnifiedMediaCanvas", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMobilePreviewHostEnabled", "getUnifiedPreviewEntry", "()Lcom/larus/platform/model/preview/MediaEntry;", "getHideAlbumEntranceInInjectedInput", "getOnlyDisplayVideo", "getSupportOriginalImage", "getLandingTabIndex", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "copy", "(Ljava/util/List;IIZLcom/larus/platform/model/MediaPickerUIMode;Ljava/lang/String;ZIIIILjava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;ZLcom/larus/platform/model/preview/MediaEntry;ZZZI)Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;", "describeContents", "equals", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaGalleryUIConfig implements Parcelable {
    public static final Parcelable.Creator<MediaGalleryUIConfig> CREATOR = null;
    public static final a G = null;
    public final boolean A;
    public final MediaEntry B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final int F;
    public final List<MediaTab> a;
    public final int b;
    public final int c;
    public final boolean d;
    public final MediaPickerUIMode e;
    public final String f;
    public final boolean g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final Integer l;
    public final Integer m;
    public final int n;
    public final Integer o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final List<String> v;
    public final String w;
    public final String x;
    public final boolean y;
    public final Boolean z;

    public static final class a {
        public MediaEntry A;
        public boolean B;
        public boolean C;
        public int D;
        public boolean E;
        public int F;
        public List<? extends MediaTab> a;
        public int b;
        public boolean c;
        public int d;
        public MediaPickerUIMode e;
        public String f;
        public boolean g;
        public int h;
        public int i;
        public int j;
        public int k;
        public Integer l;
        public Integer m;
        public Integer n;
        public boolean o;
        public boolean p;
        public String q;
        public String r;
        public String s;
        public String t;
        public List<String> u;
        public String v;
        public String w;
        public boolean x;
        public Boolean y;
        public boolean z;

        public final MediaGalleryUIConfig a() {
            List<? extends MediaTab> r2 = this.a;
            int r3 = this.b;
            int r4 = this.d;
            boolean r5 = this.c;
            MediaPickerUIMode r6 = this.e;
            String r7 = this.f;
            boolean r8 = this.g;
            int r10 = this.h;
            int r11 = this.i;
            int r12 = this.j;
            Integer r13 = this.l;
            Integer r14 = this.m;
            int r15 = this.k;
            Integer r1 = this.n;
            boolean r9 = this.o;
            boolean r16 = this.p;
            String r17 = this.q;
            String r18 = this.r;
            String r19 = this.s;
            String r20 = this.t;
            List<String> r21 = this.u;
            String r22 = this.v;
            String r23 = this.w;
            boolean r24 = this.x;
            Boolean r25 = this.y;
            boolean r26 = this.z;
            MediaEntry r27 = this.A;
            boolean r28 = this.B;
            boolean r29 = this.C;
            return new MediaGalleryUIConfig(r2, r3, r4, r5, r6, r7, r8, this.D, r10, r11, r12, r13, r14, r15, r1, r9, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, this.E, this.F);
        }

        public a() {
            MediaTab r0 = MediaTab.ALL;
            this.a = CollectionsKt.listOf(r0);
            this.b = 4;
            this.d = 1;
            this.e = MediaPickerUIMode.NORMAL;
            this.f = "album_display";
            this.t = "";
            this.u = CollectionsKt.emptyList();
            this.v = "";
            this.w = "";
            this.F = r0.getId();
        }
    }

    public static final class b {
    }

    public static final class c implements Parcelable.Creator<MediaGalleryUIConfig> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final MediaGalleryUIConfig createFromParcel(Parcel r38) {
            Intrinsics.checkNotNullParameter(r38, "parcel");
            int r0 = r38.readInt();
            ArrayList r2 = new ArrayList(r0);
            int r4 = 0;
        L3:
            if (r4 == r0) goto L5;
            r2.add(MediaTab.valueOf(r38.readString()));
            r4 = r4 + 1;
            goto L3
        L5:
            int r1 = r38.readInt();
            int r5 = r38.readInt();
            if (r38.readInt() == 0) goto L8;
            boolean r6 = true;
        L9:
            MediaPickerUIMode r7 = MediaPickerUIMode.valueOf(r38.readString());
            String r8 = r38.readString();
            if (r38.readInt() == 0) goto L12;
            boolean r9 = true;
        L13:
            int r10 = r38.readInt();
            int r11 = r38.readInt();
            int r12 = r38.readInt();
            int r13 = r38.readInt();
            MediaEntry r15 = null;
            if (r38.readInt() != 0) goto L16;
            Integer r14 = null;
        L18:
            if (r38.readInt() != 0) goto L20;
            Integer r16 = null;
        L21:
            int r17 = r38.readInt();
            if (r38.readInt() != 0) goto L24;
            Integer r18 = null;
        L26:
            if (r38.readInt() == 0) goto L28;
            boolean r19 = true;
        L30:
            if (r38.readInt() == 0) goto L32;
            boolean r20 = true;
        L33:
            String r21 = r38.readString();
            String r22 = r38.readString();
            String r23 = r38.readString();
            String r24 = r38.readString();
            ArrayList<String> r25 = r38.createStringArrayList();
            String r26 = r38.readString();
            String r27 = r38.readString();
            if (r38.readInt() == 0) goto L36;
            boolean r28 = true;
        L38:
            if (r38.readInt() != 0) goto L41;
            Boolean r29 = null;
        L46:
            if (r38.readInt() == 0) goto L48;
            boolean r30 = true;
        L50:
            if (r38.readInt() == 0) goto L53;
            r15 = MediaEntry.valueOf(r38.readString());
        L53:
            MediaEntry r31 = r15;
            if (r38.readInt() == 0) goto L56;
            boolean r32 = true;
        L58:
            if (r38.readInt() == 0) goto L60;
            boolean r34 = true;
        L62:
            if (r38.readInt() == 0) goto L64;
            boolean r35 = true;
        L66:
            return new MediaGalleryUIConfig(r2, r1, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r34, r35, r38.readInt());
        L64:
            r35 = false;
            goto L66
        L60:
            r34 = false;
            goto L62
        L56:
            r32 = false;
            goto L58
        L48:
            r30 = false;
            goto L50
        L41:
            if (r38.readInt() == 0) goto L43;
            boolean r210 = true;
        L44:
            r29 = Boolean.valueOf(r210);
            goto L46
        L43:
            r210 = false;
            goto L44
        L36:
            r28 = false;
            goto L38
        L32:
            r20 = false;
            goto L33
        L28:
            r19 = false;
            goto L30
        L24:
            r18 = Integer.valueOf(r38.readInt());
            goto L26
        L20:
            r16 = Integer.valueOf(r38.readInt());
            goto L21
        L16:
            r14 = Integer.valueOf(r38.readInt());
            goto L18
        L12:
            r9 = false;
            goto L13
        L8:
            r6 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final MediaGalleryUIConfig[] newArray(int r1) {
            return new MediaGalleryUIConfig[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MediaGalleryUIConfig) == true) goto L8;
        return false;
    L8:
        MediaGalleryUIConfig r6 = (MediaGalleryUIConfig) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (this.q == r6.q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r6.x) == true) goto L81;
        return false;
    L81:
        if (this.y == r6.y) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r6.z) == true) goto L87;
        return false;
    L87:
        if (this.A == r6.A) goto L90;
        return false;
    L90:
        if (this.B == r6.B) goto L93;
        return false;
    L93:
        if (this.C == r6.C) goto L96;
        return false;
    L96:
        if (this.D == r6.D) goto L99;
        return false;
    L99:
        if (this.E == r6.E) goto L102;
        return false;
    L102:
        if (this.F == r6.F) goto L104;
        return false;
    L104:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((r0 + r1) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        if (this.g == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((((((((r3 + r4) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31;
        Integer r6 = this.l;
        int r7 = 0;
        if (r6 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r5 + r8) * 31;
        Integer r10 = this.m;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.n) * 31;
        Integer r13 = this.o;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.p == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        if (this.q == false) goto L29;
        int r18 = 1231;
    L30:
        int r19 = (r17 + r18) * 31;
        String r20 = this.r;
        if (r20 != null) goto L33;
        int r21 = 0;
    L34:
        int r22 = (r19 + r21) * 31;
        String r23 = this.s;
        if (r23 != null) goto L37;
        int r24 = 0;
    L38:
        int r25 = (r22 + r24) * 31;
        String r26 = this.t;
        if (r26 != null) goto L41;
        int r27 = 0;
    L42:
        int r28 = (((((((((r25 + r27) * 31) + this.u.hashCode()) * 31) + this.v.hashCode()) * 31) + this.w.hashCode()) * 31) + this.x.hashCode()) * 31;
        if (this.y == false) goto L45;
        int r29 = 1231;
    L46:
        int r30 = (r28 + r29) * 31;
        Boolean r31 = this.z;
        if (r31 != null) goto L49;
        int r32 = 0;
    L50:
        int r33 = (r30 + r32) * 31;
        if (this.A == false) goto L53;
        int r34 = 1231;
    L54:
        int r35 = (r33 + r34) * 31;
        MediaEntry r36 = this.B;
        if (r36 == null) goto L58;
        r7 = r36.hashCode();
    L58:
        int r37 = (r35 + r7) * 31;
        if (this.C == false) goto L61;
        int r38 = 1231;
    L62:
        int r39 = (r37 + r38) * 31;
        if (this.D == false) goto L65;
        int r40 = 1231;
    L66:
        int r41 = (r39 + r40) * 31;
        if (this.E == true) goto L71;
        r2 = 1237;
    L71:
        return ((r41 + r2) * 31) + this.F;
    L65:
        r40 = 1237;
        goto L66
    L61:
        r38 = 1237;
        goto L62
    L53:
        r34 = 1237;
        goto L54
    L49:
        r32 = r31.hashCode();
        goto L50
    L45:
        r29 = 1237;
        goto L46
    L41:
        r27 = r26.hashCode();
        goto L42
    L37:
        r24 = r23.hashCode();
        goto L38
    L33:
        r21 = r20.hashCode();
        goto L34
    L29:
        r18 = 1237;
        goto L30
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r6.hashCode();
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        List<MediaTab> r5 = this.a;
        r3.writeInt(r5.size());
        Iterator<MediaTab> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r3.writeString(r6.next().name());
        goto L4
    L6:
        r3.writeInt(this.b);
        r3.writeInt(this.c);
        r3.writeInt(this.d ? 1 : 0);
        r3.writeString(this.e.name());
        r3.writeString(this.f);
        r3.writeInt(this.g ? 1 : 0);
        r3.writeInt(this.h);
        r3.writeInt(this.i);
        r3.writeInt(this.j);
        r3.writeInt(this.k);
        Integer r7 = this.l;
        if (r7 != null) goto L9;
        r3.writeInt(0);
    L10:
        Integer r8 = this.m;
        if (r8 != null) goto L13;
        r3.writeInt(0);
    L14:
        r3.writeInt(this.n);
        Integer r9 = this.o;
        if (r9 != null) goto L17;
        r3.writeInt(0);
    L18:
        r3.writeInt(this.p ? 1 : 0);
        r3.writeInt(this.q ? 1 : 0);
        r3.writeString(this.r);
        r3.writeString(this.s);
        r3.writeString(this.t);
        r3.writeString(this.u);
        r3.writeStringList(this.v);
        r3.writeString(this.w);
        r3.writeString(this.x);
        r3.writeInt(this.y ? 1 : 0);
        Boolean r10 = this.z;
        if (r10 != null) goto L21;
        r3.writeInt(0);
    L22:
        r3.writeInt(this.A ? 1 : 0);
        MediaEntry r11 = this.B;
        if (r11 != null) goto L25;
        r3.writeInt(0);
    L26:
        r3.writeInt(this.C ? 1 : 0);
        r3.writeInt(this.D ? 1 : 0);
        r3.writeInt(this.E ? 1 : 0);
        r3.writeInt(this.F);
        return;
    L25:
        r3.writeInt(1);
        r3.writeString(r11.name());
        goto L26
    L21:
        r3.writeInt(1);
        r3.writeInt(r10.booleanValue() ? 1 : 0);
        goto L22
    L17:
        r3.writeInt(1);
        r3.writeInt(r9.intValue());
        goto L18
    L13:
        r3.writeInt(1);
        r3.writeInt(r8.intValue());
        goto L14
    L9:
        r3.writeInt(1);
        r3.writeInt(r7.intValue());
        goto L10
    }

    static {
        CREATOR = new c();
        a r0 = new a();
        List<? extends MediaTab> r1 = CollectionsKt.listOf(MediaTab.ALL);
        Intrinsics.checkNotNullParameter(r1, "tabs");
        r0.a = r1;
        r0.b = 4;
        r0.j = i5.b();
        G = r0;
    }

    public final String toString() {
        return "tabs:" + this.a + " spanCount:" + this.b + " maxSelectedCount:" + this.c + " isSingleSelectionMode:" + this.d + " mode:" + this.e + " displayType:" + this.f + " isSupportVideo:" + this.g + " bottomMenuInitHeight:" + this.h + " bottomMenuTotalHeight:" + this.i + " multiSelectConfirmed:" + this.p + " supportInput:" + this.q + " suggestedActionProvider:" + this.r + " onlyDisplayVideo:" + this.D + " supportOriginalImage:" + this.E + " landingTabIndex:" + this.F;
    }

    public static MediaGalleryUIConfig a(MediaGalleryUIConfig r37, int r38, boolean r39, String r40, int r41) {
        if ((r41 & 1) == 0) goto L5;
        List<MediaTab> r5 = r37.a;
    L7:
        if ((r41 & 2) == 0) goto L9;
        int r6 = r37.b;
    L11:
        if ((r41 & 4) == 0) goto L13;
        int r7 = r37.c;
    L15:
        if ((r41 & 8) == 0) goto L17;
        boolean r8 = r37.d;
    L19:
        if ((r41 & 16) == 0) goto L21;
        MediaPickerUIMode r9 = r37.e;
    L23:
        if ((r41 & 32) == 0) goto L25;
        String r10 = r37.f;
    L27:
        if ((r41 & 64) == 0) goto L29;
        boolean r11 = r37.g;
    L31:
        if ((r41 & 128) == 0) goto L33;
        int r12 = r37.h;
    L35:
        if ((r41 & 256) == 0) goto L37;
        int r13 = r37.i;
    L39:
        if ((r41 & 512) == 0) goto L41;
        int r14 = r37.j;
    L43:
        if ((r41 & 1024) == 0) goto L45;
        int r15 = r37.k;
    L47:
        if ((r41 & 2048) == 0) goto L49;
        Integer r16 = r37.l;
    L51:
        if ((r41 & 4096) == 0) goto L53;
        Integer r17 = r37.m;
    L55:
        if ((r41 & 8192) == 0) goto L57;
        int r18 = r37.n;
    L59:
        if ((r41 & 16384) == 0) goto L61;
        Integer r19 = r37.o;
    L63:
        if ((32768 & r41) == 0) goto L65;
        boolean r20 = r37.p;
    L67:
        if ((65536 & r41) == 0) goto L69;
        boolean r21 = r37.q;
    L71:
        if ((131072 & r41) == 0) goto L73;
        String r22 = r37.r;
    L75:
        if ((262144 & r41) == 0) goto L77;
        String r23 = r37.s;
    L79:
        if ((524288 & r41) == 0) goto L81;
        String r24 = r37.t;
    L83:
        if ((1048576 & r41) == 0) goto L85;
        String r2 = r37.u;
    L87:
        if ((r41 & 2097152) == 0) goto L89;
        List<String> r3 = r37.v;
    L91:
        if ((r41 & 4194304) == 0) goto L93;
        String r4 = r37.w;
    L94:
        int r310 = r15;
        if ((r41 & 8388608) == 0) goto L97;
        String r110 = r37.x;
    L98:
        int r311 = r14;
        if ((r41 & 16777216) == 0) goto L101;
        boolean r29 = r37.y;
    L103:
        if ((33554432 & r41) == 0) goto L105;
        Boolean r30 = r37.z;
    L107:
        if ((67108864 & r41) == 0) goto L109;
        boolean r31 = r37.A;
    L111:
        if ((134217728 & r41) == 0) goto L113;
        MediaEntry r32 = r37.B;
    L115:
        if ((268435456 & r41) == 0) goto L117;
        boolean r33 = r37.C;
    L119:
        if ((536870912 & r41) == 0) goto L121;
        boolean r34 = r37.D;
    L123:
        if ((1073741824 & r41) == 0) goto L125;
        boolean r35 = r37.E;
    L127:
        if ((r41 & Integer.MIN_VALUE) == 0) goto L129;
        int r36 = r37.F;
    L130:
        r37.getClass();
        Intrinsics.checkNotNullParameter(r5, "tabs");
        Intrinsics.checkNotNullParameter(r9, "mode");
        Intrinsics.checkNotNullParameter(r10, "displayType");
        Intrinsics.checkNotNullParameter(r2, "initialInputSourceNodeId");
        Intrinsics.checkNotNullParameter(r3, "initialAttachmentUris");
        Intrinsics.checkNotNullParameter(r4, "albumNodeId");
        Intrinsics.checkNotNullParameter(r110, "upstreamAlbumNodeId");
        String r25 = r2;
        List<String> r26 = r3;
        return new MediaGalleryUIConfig(r5, r6, r7, r8, r9, r10, r11, r12, r13, r311, r310, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r4, r110, r29, r30, r31, r32, r33, r34, r35, r36);
    L129:
        r36 = 0;
        goto L130
    L125:
        r35 = false;
        goto L127
    L121:
        r34 = false;
        goto L123
    L117:
        r33 = false;
        goto L119
    L113:
        r32 = null;
        goto L115
    L109:
        r31 = false;
        goto L111
    L105:
        r30 = null;
        goto L107
    L101:
        r29 = false;
        goto L103
    L97:
        r110 = null;
        goto L98
    L93:
        r4 = null;
        goto L94
    L89:
        r3 = null;
        goto L91
    L85:
        r2 = null;
        goto L87
    L81:
        r24 = null;
        goto L83
    L77:
        r23 = null;
        goto L79
    L73:
        r22 = null;
        goto L75
    L69:
        r21 = false;
        goto L71
    L65:
        r20 = false;
        goto L67
    L61:
        r19 = null;
        goto L63
    L57:
        r18 = 0;
        goto L59
    L53:
        r17 = null;
        goto L55
    L49:
        r16 = null;
        goto L51
    L45:
        r15 = 0;
        goto L47
    L41:
        r14 = 0;
        goto L43
    L37:
        r13 = 0;
        goto L39
    L33:
        r12 = 0;
        goto L35
    L29:
        r11 = false;
        goto L31
    L25:
        r10 = r40;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = r39;
        goto L19
    L13:
        r7 = r38;
        goto L15
    L9:
        r6 = 0;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MediaGalleryUIConfig(List<? extends MediaTab> r10, int r11, int r12, boolean r13, MediaPickerUIMode r14, String r15, boolean r16, int r17, int r18, int r19, int r20, Integer r21, Integer r22, int r23, Integer r24, boolean r25, boolean r26, String r27, String r28, String r29, String r30, List<String> r31, String r32, String r33, boolean r34, Boolean r35, boolean r36, MediaEntry r37, boolean r38, boolean r39, boolean r40, int r41) {
        Intrinsics.checkNotNullParameter(r10, "tabs");
        Intrinsics.checkNotNullParameter(r14, "mode");
        Intrinsics.checkNotNullParameter(r15, "displayType");
        Intrinsics.checkNotNullParameter(r30, "initialInputSourceNodeId");
        Intrinsics.checkNotNullParameter(r31, "initialAttachmentUris");
        Intrinsics.checkNotNullParameter(r32, "albumNodeId");
        Intrinsics.checkNotNullParameter(r33, "upstreamAlbumNodeId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r20;
        this.l = r21;
        this.m = r22;
        this.n = r23;
        this.o = r24;
        this.p = r25;
        this.q = r26;
        this.r = r27;
        this.s = r28;
        this.t = r29;
        this.u = r30;
        this.v = r31;
        this.w = r32;
        this.x = r33;
        this.y = r34;
        this.z = r35;
        this.A = r36;
        this.B = r37;
        this.C = r38;
        this.D = r39;
        this.E = r40;
        this.F = r41;
    }
}
