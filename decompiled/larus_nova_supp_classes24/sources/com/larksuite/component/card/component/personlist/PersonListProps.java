package com.larksuite.component.card.component.personlist;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010&\u001a\u00020\u000eHÆ\u0003J\\\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\fHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonListProps;", "", "tag", "", "id", "persons", "", "Lcom/larksuite/component/card/component/personlist/PersonInfo;", "showAvatar", "", "showName", "lines", "", "styles", "Lcom/larksuite/component/card/component/personlist/PersonStyle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZLjava/lang/Integer;Lcom/larksuite/component/card/component/personlist/PersonStyle;)V", "getTag", "()Ljava/lang/String;", "getId", "getPersons", "()Ljava/util/List;", "setPersons", "(Ljava/util/List;)V", "getShowAvatar", "()Z", "getShowName", "getLines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStyles", "()Lcom/larksuite/component/card/component/personlist/PersonStyle;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZLjava/lang/Integer;Lcom/larksuite/component/card/component/personlist/PersonStyle;)Lcom/larksuite/component/card/component/personlist/PersonListProps;", "equals", "other", "hashCode", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PersonListProps {
    private final String id;
    private final Integer lines;
    private List<PersonInfo> persons;
    private final boolean showAvatar;
    private final boolean showName;
    private final PersonStyle styles;
    private final String tag;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PersonListProps copy$default(PersonListProps r5, String r6, String r7, List r8, boolean r9, boolean r10, Integer r11, PersonStyle r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.tag;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.id;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.persons;
    L11:
        List r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.showAvatar;
    L14:
        boolean r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.showName;
    L17:
        boolean r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.lines;
    L20:
        Integer r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.styles;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.tag;
    }

    public final String component2() {
        return this.id;
    }

    public final List<PersonInfo> component3() {
        return this.persons;
    }

    public final boolean component4() {
        return this.showAvatar;
    }

    public final boolean component5() {
        return this.showName;
    }

    public final Integer component6() {
        return this.lines;
    }

    public final PersonStyle component7() {
        return this.styles;
    }

    public final PersonListProps copy(String r10, String r11, List<PersonInfo> r12, boolean r13, boolean r14, Integer r15, PersonStyle r16) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "id");
        Intrinsics.checkNotNullParameter(r12, "persons");
        Intrinsics.checkNotNullParameter(r16, "styles");
        return new PersonListProps(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PersonListProps) == true) goto L8;
        return false;
    L8:
        PersonListProps r6 = (PersonListProps) r5;
        if (Intrinsics.areEqual(this.tag, r6.tag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.persons, r6.persons) == true) goto L18;
        return false;
    L18:
        if (this.showAvatar == r6.showAvatar) goto L21;
        return false;
    L21:
        if (this.showName == r6.showName) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lines, r6.lines) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.styles, r6.styles) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.tag.hashCode() * 31) + this.id.hashCode()) * 31) + this.persons.hashCode()) * 31;
        int r2 = 1231;
        if (this.showAvatar == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.showName == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (r3 + r2) * 31;
        Integer r5 = this.lines;
        if (r5 != null) goto L13;
        int r6 = 0;
    L15:
        return ((r4 + r6) * 31) + this.styles.hashCode();
    L13:
        r6 = r5.hashCode();
        goto L15
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "PersonListProps(tag=" + this.tag + ", id=" + this.id + ", persons=" + this.persons + ", showAvatar=" + this.showAvatar + ", showName=" + this.showName + ", lines=" + this.lines + ", styles=" + this.styles + ')';
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getLines() {
        return this.lines;
    }

    public final List<PersonInfo> getPersons() {
        return this.persons;
    }

    public final boolean getShowAvatar() {
        return this.showAvatar;
    }

    public final boolean getShowName() {
        return this.showName;
    }

    public final PersonStyle getStyles() {
        return this.styles;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setPersons(List<PersonInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.persons = r2;
    }

    public PersonListProps(String r2, String r3, List<PersonInfo> r4, boolean r5, boolean r6, Integer r7, PersonStyle r8) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, "persons");
        Intrinsics.checkNotNullParameter(r8, "styles");
        this.tag = r2;
        this.id = r3;
        this.persons = r4;
        this.showAvatar = r5;
        this.showName = r6;
        this.lines = r7;
        this.styles = r8;
    }

    public /* synthetic */ PersonListProps(String r10, String r11, List r12, boolean r13, boolean r14, Integer r15, PersonStyle r16, int r17, DefaultConstructorMarker r19) {
        if ((r17 & 32) == 0) goto L5;
        Integer r7 = 0;
    L6:
        this(r10, r11, r12, r13, r14, r7, r16);
        return;
    L5:
        r7 = r15;
        goto L6
    }
}
