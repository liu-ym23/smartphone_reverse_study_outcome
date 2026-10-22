package com.larus.agents.impl.experience;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/agents/impl/experience/WorkExperienceSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "HARNESS", "MODEL", "USER", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum WorkExperienceSource extends Enum<WorkExperienceSource> {
    public static final a Companion = null;
    public static final WorkExperienceSource HARNESS = null;
    public static final WorkExperienceSource MODEL = null;
    public static final WorkExperienceSource UNKNOWN = null;
    public static final WorkExperienceSource USER = null;
    public static final /* synthetic */ WorkExperienceSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static WorkExperienceSource a(Integer r4) {
            Iterator r0 = WorkExperienceSource.getEntries().iterator();
        L4:
            if (r0.hasNext() == false) goto L14;
            Object r1 = r0.next();
            int r2 = ((WorkExperienceSource) r1).getValue();
            if (r4 != null) goto L9;
        L11:
            boolean r3 = false;
        L12:
            if (r3 == false) goto L4;
        L15:
            WorkExperienceSource r5 = (WorkExperienceSource) r1;
            if (r5 == null) goto L18;
            return r5;
        L18:
            return WorkExperienceSource.UNKNOWN;
        L9:
            if (r2 != r4.intValue()) goto L11;
            r3 = true;
            goto L12
        L14:
            r1 = null;
            goto L15
        }
    }

    public static EnumEntries<WorkExperienceSource> getEntries() {
        return b;
    }

    static {
        WorkExperienceSource r0 = new WorkExperienceSource("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        WorkExperienceSource r1 = new WorkExperienceSource("HARNESS", 1, 1);
        HARNESS = r1;
        WorkExperienceSource r3 = new WorkExperienceSource("MODEL", 2, 2);
        MODEL = r3;
        WorkExperienceSource r5 = new WorkExperienceSource("USER", 3, 3);
        USER = r5;
        WorkExperienceSource[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static WorkExperienceSource[] values() {
        return (WorkExperienceSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static WorkExperienceSource valueOf(String r1) {
        return (WorkExperienceSource) r27.a.a(WorkExperienceSource.class, r1);
    }

    public WorkExperienceSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
