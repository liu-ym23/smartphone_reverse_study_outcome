package com.larus.uaigc.createpage.component.inspiration;

import com.larus.bmhome.instruction.repo.InspireScene;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0018\u00010\bHÆ\u0003JJ\u0010\u0016\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/larus/uaigc/createpage/component/inspiration/ImageInspirationState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "scene", "", "inspirationList", "", "Lcom/larus/bmhome/instruction/repo/ImgInspirePrompt;", "inspirationMap", "", "", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/Map;)V", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInspirationList", "()Ljava/util/List;", "getInspirationMap", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/Map;)Lcom/larus/uaigc/createpage/component/inspiration/ImageInspirationState;", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageInspirationState implements w1a.b {
    private final List<fq8.e> inspirationList;
    private final Map<Integer, List<String>> inspirationMap;
    private final Integer scene;

    public ImageInspirationState() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageInspirationState copy$default(ImageInspirationState r0, Integer r1, List r2, Map r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.scene;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.inspirationList;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.inspirationMap;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Integer component1() {
        return this.scene;
    }

    public final List<fq8.e> component2() {
        return this.inspirationList;
    }

    public final Map<Integer, List<String>> component3() {
        return this.inspirationMap;
    }

    public final ImageInspirationState copy(@InspireScene Integer r2, List<fq8.e> r3, Map<Integer, ? extends List<String>> r4) {
        return new ImageInspirationState(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImageInspirationState) == true) goto L8;
        return false;
    L8:
        ImageInspirationState r6 = (ImageInspirationState) r5;
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.inspirationList, r6.inspirationList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inspirationMap, r6.inspirationMap) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.scene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<fq8.e> r4 = this.inspirationList;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Map<Integer, List<String>> r7 = this.inspirationMap;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ImageInspirationState(scene=" + this.scene + ", inspirationList=" + this.inspirationList + ", inspirationMap=" + this.inspirationMap + ')';
    }

    public final List<fq8.e> getInspirationList() {
        return this.inspirationList;
    }

    public final Map<Integer, List<String>> getInspirationMap() {
        return this.inspirationMap;
    }

    public final Integer getScene() {
        return this.scene;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageInspirationState(@InspireScene Integer r1, List<fq8.e> r2, Map<Integer, ? extends List<String>> r3) {
        this.scene = r1;
        this.inspirationList = r2;
        this.inspirationMap = r3;
    }

    public /* synthetic */ ImageInspirationState(Integer r2, List r3, Map r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
