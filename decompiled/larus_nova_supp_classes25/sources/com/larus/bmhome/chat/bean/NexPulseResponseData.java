package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u0015*\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u001bJ\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/larus/bmhome/chat/bean/NexPulseResponseData;", "", "candidateList", "", "Lcom/larus/bmhome/chat/bean/NexPulseCandidate;", "categoryCandidateList", "nexPulseType", "", "conf", "Lcom/larus/bmhome/chat/bean/NexPulseConf;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/NexPulseConf;)V", "getCandidateList", "()Ljava/util/List;", "getCategoryCandidateList", "getNexPulseType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConf", "()Lcom/larus/bmhome/chat/bean/NexPulseConf;", "isValid", "", "toSuggestItems", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;", "isInTaskMode", "(Ljava/lang/Boolean;)Ljava/util/List;", "isVisibleInMode", "(Lcom/larus/bmhome/chat/bean/NexPulseCandidate;Ljava/lang/Boolean;)Z", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/NexPulseConf;)Lcom/larus/bmhome/chat/bean/NexPulseResponseData;", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class NexPulseResponseData {

    @SerializedName("candidate_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<NexPulseCandidate> candidateList;

    @SerializedName("category_candidate_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<NexPulseCandidate> categoryCandidateList;

    @SerializedName("conf")
    private final NexPulseConf conf;

    @SerializedName("nexpulse_type")
    private final Integer nexPulseType;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            TextCandidateConf r4 = ((NexPulseCandidate) r2).getTextConf();
            int r0 = Integer.MAX_VALUE;
            if (r4 == null) goto L7;
            Integer r5 = r4.getPosition();
            if (r5 == null) goto L7;
            int r6 = r5.intValue();
        L8:
            Integer r7 = Integer.valueOf(r6);
            TextCandidateConf r8 = ((NexPulseCandidate) r3).getTextConf();
            if (r8 == null) goto L14;
            Integer r9 = r8.getPosition();
            if (r9 == null) goto L14;
            r0 = r9.intValue();
        L14:
            return ComparisonsKt.compareValues(r7, Integer.valueOf(r0));
        L7:
            r6 = Integer.MAX_VALUE;
            goto L8
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            TextCandidateConf r4 = ((NexPulseCandidate) r2).getTextConf();
            int r0 = Integer.MAX_VALUE;
            if (r4 == null) goto L7;
            Integer r5 = r4.getPosition();
            if (r5 == null) goto L7;
            int r6 = r5.intValue();
        L8:
            Integer r7 = Integer.valueOf(r6);
            TextCandidateConf r8 = ((NexPulseCandidate) r3).getTextConf();
            if (r8 == null) goto L14;
            Integer r9 = r8.getPosition();
            if (r9 == null) goto L14;
            r0 = r9.intValue();
        L14:
            return ComparisonsKt.compareValues(r7, Integer.valueOf(r0));
        L7:
            r6 = Integer.MAX_VALUE;
            goto L8
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            TextCandidateConf r4 = ((NexPulseCandidate) r2).getTextConf();
            int r0 = Integer.MAX_VALUE;
            if (r4 == null) goto L7;
            Integer r5 = r4.getPosition();
            if (r5 == null) goto L7;
            int r6 = r5.intValue();
        L8:
            Integer r7 = Integer.valueOf(r6);
            TextCandidateConf r8 = ((NexPulseCandidate) r3).getTextConf();
            if (r8 == null) goto L14;
            Integer r9 = r8.getPosition();
            if (r9 == null) goto L14;
            r0 = r9.intValue();
        L14:
            return ComparisonsKt.compareValues(r7, Integer.valueOf(r0));
        L7:
            r6 = Integer.MAX_VALUE;
            goto L8
        }
    }

    public NexPulseResponseData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NexPulseResponseData copy$default(NexPulseResponseData r0, List r1, List r2, Integer r3, NexPulseConf r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.candidateList;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.categoryCandidateList;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.nexPulseType;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.conf;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final List<NexPulseCandidate> component1() {
        return this.candidateList;
    }

    public final List<NexPulseCandidate> component2() {
        return this.categoryCandidateList;
    }

    public final Integer component3() {
        return this.nexPulseType;
    }

    public final NexPulseConf component4() {
        return this.conf;
    }

    public final NexPulseResponseData copy(List<NexPulseCandidate> r2, List<NexPulseCandidate> r3, Integer r4, NexPulseConf r5) {
        return new NexPulseResponseData(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NexPulseResponseData) == true) goto L8;
        return false;
    L8:
        NexPulseResponseData r6 = (NexPulseResponseData) r5;
        if (Intrinsics.areEqual(this.candidateList, r6.candidateList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.categoryCandidateList, r6.categoryCandidateList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nexPulseType, r6.nexPulseType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.conf, r6.conf) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        List<NexPulseCandidate> r0 = this.candidateList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<NexPulseCandidate> r4 = this.categoryCandidateList;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.nexPulseType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        NexPulseConf r10 = this.conf;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "NexPulseResponseData(candidateList=" + this.candidateList + ", categoryCandidateList=" + this.categoryCandidateList + ", nexPulseType=" + this.nexPulseType + ", conf=" + this.conf + ')';
    }

    public final boolean isValid() {
        Integer r0 = this.nexPulseType;
        if (r0 != null) goto L6;
    L24:
        if (r0 != null) goto L27;
    L28:
        if (r0 != null) goto L31;
        return false;
    L31:
        if (r0.intValue() != 4) goto L43;
    L32:
        List<NexPulseCandidate> r1 = this.candidateList;
        if (r1 != null) goto L35;
    L38:
        boolean r2 = true;
    L39:
        if (r2 == true) goto L44;
    L23:
        return true;
    L44:
        return false;
    L35:
        if (r1.isEmpty() == true) goto L38;
        r2 = false;
        goto L39
    L43:
        return false;
    L27:
        if (r0.intValue() == 2) goto L32;
    L6:
        if (r0.intValue() != 1) goto L24;
        List<NexPulseCandidate> r3 = this.candidateList;
        if (r3 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == false) goto L23;
        List<NexPulseCandidate> r5 = this.categoryCandidateList;
        if (r5 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == false) goto L23;
        return false;
    L18:
        if (r5.isEmpty() == true) goto L21;
        r6 = false;
        goto L22
    L10:
        if (r3.isEmpty() == true) goto L13;
        r4 = false;
        goto L14
    }

    public final List<NexPulseCandidate> getCandidateList() {
        return this.candidateList;
    }

    public final List<NexPulseCandidate> getCategoryCandidateList() {
        return this.categoryCandidateList;
    }

    public final NexPulseConf getConf() {
        return this.conf;
    }

    public final Integer getNexPulseType() {
        return this.nexPulseType;
    }

    public final List<PromptContent.SuggestItem> toSuggestItems(Boolean r12) {
        List<NexPulseCandidate> r0 = this.categoryCandidateList;
        if (r0 != null) goto L6;
        r0 = CollectionsKt.emptyList();
    L6:
        if (r0.isEmpty() == false) goto L21;
        List<NexPulseCandidate> r1 = this.candidateList;
        if (r1 != null) goto L10;
        r1 = CollectionsKt.emptyList();
    L10:
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L12:
        if (r3.hasNext() == false) goto L16;
        Object r6 = r3.next();
        if (isVisibleInMode((NexPulseCandidate) r6, r12) == false) goto L12;
        r2.add(r6);
        goto L12
    L16:
        List r13 = CollectionsKt.sortedWith(r2, new a());
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r14 = r13.iterator();
    L18:
        if (r14.hasNext() == false) goto L20;
        r4.add(NexPulseCandidate.toSuggestItem$default((NexPulseCandidate) r14.next(), null, false, 3, null));
        goto L18
    L20:
        return r4;
    L21:
        List<NexPulseCandidate> r5 = this.candidateList;
        if (r5 != null) goto L24;
        r5 = CollectionsKt.emptyList();
    L24:
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r5.iterator();
    L26:
        if (r8.hasNext() == false) goto L30;
        Object r9 = r8.next();
        if (isVisibleInMode((NexPulseCandidate) r9, r12) == false) goto L26;
        r7.add(r9);
        goto L26
    L30:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r7.iterator();
    L31:
        boolean r15 = true;
        if (r11.hasNext() == false) goto L53;
        Object r16 = r11.next();
        NexPulseCandidate r17 = (NexPulseCandidate) r16;
        String r18 = r17.getCategoryId();
        if (r18 != null) goto L36;
    L39:
        boolean r19 = true;
    L40:
        if (r19 == false) goto L51;
        String r20 = r17.getParentId();
        if (r20 != null) goto L44;
    L47:
        boolean r21 = true;
    L48:
        if (r21 == false) goto L51;
        r15 = false;
        goto L51
    L44:
        if (r20.length() == 0) goto L47;
        r21 = false;
    L51:
        if (r15 == false) goto L31;
        r10.add(r16);
        goto L31
    L36:
        if (r18.length() == 0) goto L39;
        r19 = false;
        goto L40
    L53:
        LinkedHashMap r22 = new LinkedHashMap();
        Iterator r23 = r10.iterator();
    L55:
        if (r23.hasNext() == false) goto L63;
        Object r24 = r23.next();
        NexPulseCandidate r25 = (NexPulseCandidate) r24;
        String r110 = r25.getCategoryId();
        if (r110 != null) goto L59;
        r110 = r25.getParentId();
    L59:
        Object r26 = r22.get(r110);
        if (r26 != null) goto L62;
        r26 = new ArrayList();
        r22.put(r110, r26);
    L62:
        ((List) r26).add(r24);
        goto L55
    L63:
        ArrayList r27 = new ArrayList();
        Iterator<T> r28 = r0.iterator();
    L65:
        if (r28.hasNext() == false) goto L69;
        Object r29 = r28.next();
        if (isVisibleInMode((NexPulseCandidate) r29, r12) == false) goto L65;
        r27.add(r29);
        goto L65
    L69:
        List r111 = CollectionsKt.sortedWith(r27, new b());
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r112 = r111.iterator();
    L71:
        if (r112.hasNext() == false) goto L86;
        NexPulseCandidate r31 = (NexPulseCandidate) r112.next();
        List r32 = (List) r22.get(r31.getGid());
        if (r32 != null) goto L75;
        r32 = (List) r22.get(r31.getCategoryId());
    L75:
        if (r32 != null) goto L77;
        r32 = CollectionsKt.emptyList();
    L77:
        List r33 = CollectionsKt.sortedWith(r32, new c());
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
        Iterator r35 = r33.iterator();
    L79:
        if (r35.hasNext() == false) goto L82;
        r34.add(NexPulseCandidate.toSuggestItem$default((NexPulseCandidate) r35.next(), null, false, 3, null));
        goto L79
    L82:
        if ((!r34.isEmpty()) == true) goto L85;
        r34 = null;
    L85:
        r30.add(r31.toSuggestItem(r34, true));
        goto L71
    L86:
        return r30;
    }

    private final boolean isVisibleInMode(NexPulseCandidate r3, Boolean r4) {
        Integer r5 = r3.getCandidateType();
        if (r5 != null) goto L6;
    L11:
        if (r5 != null) goto L14;
        return true;
    L14:
        if (r5.intValue() == 2) goto L16;
        return true;
    L16:
        return Intrinsics.areEqual(r4, Boolean.TRUE);
    L6:
        if (r5.intValue() != 1) goto L11;
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L19;
        return false;
    L19:
        return true;
    }

    public NexPulseResponseData(List<NexPulseCandidate> r1, List<NexPulseCandidate> r2, Integer r3, NexPulseConf r4) {
        this.candidateList = r1;
        this.categoryCandidateList = r2;
        this.nexPulseType = r3;
        this.conf = r4;
    }

    public static /* synthetic */ List toSuggestItems$default(NexPulseResponseData r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.toSuggestItems(r1);
    }

    public /* synthetic */ NexPulseResponseData(List r2, List r3, Integer r4, NexPulseConf r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
