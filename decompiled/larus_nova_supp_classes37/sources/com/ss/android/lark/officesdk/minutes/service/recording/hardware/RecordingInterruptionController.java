package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RecordingInterruptionController {
    public static final /* synthetic */ int l = 0;
    public HardwarePlaybackState a;
    public boolean b;
    public boolean c;
    public boolean d;
    public InputRecoveryPolicy e;
    public boolean f;
    public Job g;
    public Job h;
    public Job i;
    public long j;
    public Job k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/RecordingInterruptionController$InputRecoveryPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "STANDARD", "END_ON_FRESH_IDLE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum InputRecoveryPolicy extends Enum<InputRecoveryPolicy> {
        public static final InputRecoveryPolicy END_ON_FRESH_IDLE = null;
        public static final InputRecoveryPolicy STANDARD = null;
        public static final /* synthetic */ InputRecoveryPolicy[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<InputRecoveryPolicy> getEntries() {
            return b;
        }

        static {
            InputRecoveryPolicy r0 = new InputRecoveryPolicy("STANDARD", 0);
            STANDARD = r0;
            InputRecoveryPolicy r1 = new InputRecoveryPolicy("END_ON_FRESH_IDLE", 1);
            END_ON_FRESH_IDLE = r1;
            InputRecoveryPolicy[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static InputRecoveryPolicy[] values() {
            return (InputRecoveryPolicy[]) a.clone();
        }

        public static InputRecoveryPolicy valueOf(String r1) {
            return (InputRecoveryPolicy) r27.a.a(InputRecoveryPolicy.class, r1);
        }

        public InputRecoveryPolicy(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void a() {
        Job r0 = this.g;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        Job r1 = this.h;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.j++;
        Job r2 = this.i;
        if (r2 == null) goto L11;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L11:
        this.i = null;
        Job r3 = this.k;
        if (r3 == null) goto L14;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L14:
        this.g = null;
        this.h = null;
        this.k = null;
        this.e = InputRecoveryPolicy.STANDARD;
    }
}
