package com.ss.android.lark.forwardv3.configuration;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u0001:\u0002<=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u00108\u001a\u0002092\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010:\u001a\u00020,H\u0016J\b\u0010;\u001a\u00020,H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0003\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006>"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/ForwardTemplateNew;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "forwardTargetConfig", "Lcom/ss/android/lark/forwardv3/configuration/ForwardTargetConfig;", "getForwardTargetConfig", "()Lcom/ss/android/lark/forwardv3/configuration/ForwardTargetConfig;", "setForwardTargetConfig", "(Lcom/ss/android/lark/forwardv3/configuration/ForwardTargetConfig;)V", "forwardSelectConfig", "Lcom/ss/android/lark/forwardv3/configuration/ForwardSelectConfig;", "getForwardSelectConfig", "()Lcom/ss/android/lark/forwardv3/configuration/ForwardSelectConfig;", "setForwardSelectConfig", "(Lcom/ss/android/lark/forwardv3/configuration/ForwardSelectConfig;)V", "forwardCommonConfig", "Lcom/ss/android/lark/forwardv3/configuration/ForwardCommonConfig;", "getForwardCommonConfig", "()Lcom/ss/android/lark/forwardv3/configuration/ForwardCommonConfig;", "setForwardCommonConfig", "(Lcom/ss/android/lark/forwardv3/configuration/ForwardCommonConfig;)V", "forwardAdditionNoteConfig", "Lcom/ss/android/lark/forwardv3/configuration/ForwardAdditionNoteConfig;", "getForwardAdditionNoteConfig", "()Lcom/ss/android/lark/forwardv3/configuration/ForwardAdditionNoteConfig;", "setForwardAdditionNoteConfig", "(Lcom/ss/android/lark/forwardv3/configuration/ForwardAdditionNoteConfig;)V", "forwardConfirmDialogConfig", "Lcom/ss/android/lark/forwardv3/configuration/ForwardConfirmDialogConfig;", "getForwardConfirmDialogConfig", "()Lcom/ss/android/lark/forwardv3/configuration/ForwardConfirmDialogConfig;", "setForwardConfirmDialogConfig", "(Lcom/ss/android/lark/forwardv3/configuration/ForwardConfirmDialogConfig;)V", "forwardContent", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "getForwardContent", "()Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "setForwardContent", "(Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;)V", "type", "", "getType$annotations", "getType", "()I", "setType", "(I)V", "source", "Lcom/ss/android/lark/forwardv3/configuration/Forward$Source;", "getSource", "()Lcom/ss/android/lark/forwardv3/configuration/Forward$Source;", "setSource", "(Lcom/ss/android/lark/forwardv3/configuration/Forward$Source;)V", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardTemplateNew implements Parcelable {
    public static final b CREATOR = null;
    private ForwardAdditionNoteConfig forwardAdditionNoteConfig;
    private ForwardCommonConfig forwardCommonConfig;
    private ForwardConfirmDialogConfig forwardConfirmDialogConfig;
    private IForwardContent forwardContent;
    private ForwardSelectConfig forwardSelectConfig;
    private ForwardTargetConfig forwardTargetConfig;
    private Forward$Source source;
    private int type;

    public static final class a {
        public ForwardTargetConfig a;
        public ForwardSelectConfig b;
        public ForwardCommonConfig c;
        public ForwardAdditionNoteConfig d;
        public ForwardConfirmDialogConfig e;
        public IForwardContent f;
        public int g;
        public Forward$Source h;

        public final ForwardTemplateNew a() {
            ForwardTemplateNew r0 = new ForwardTemplateNew();
            r0.setForwardTargetConfig(this.a);
            r0.setForwardSelectConfig(this.b);
            r0.setForwardCommonConfig(this.c);
            r0.setForwardAdditionNoteConfig(this.d);
            r0.setForwardConfirmDialogConfig(this.e);
            r0.setForwardContent(this.f);
            r0.setType(this.g);
            r0.setSource(this.h);
            return r0;
        }

        public a() {
            this.a = new ForwardTargetConfig();
            this.b = new ForwardSelectConfig();
            this.c = new ForwardCommonConfig();
            this.d = new ForwardAdditionNoteConfig();
            this.e = new ForwardConfirmDialogConfig();
            this.h = Forward$Source.UNKNOWN;
        }
    }

    public static final class b implements Parcelable.Creator<ForwardTemplateNew> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTemplateNew createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new ForwardTemplateNew(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTemplateNew[] newArray(int r1) {
            return new ForwardTemplateNew[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Forward$Type
    public static /* synthetic */ void getType$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ForwardTemplateNew() {
        this.forwardTargetConfig = new ForwardTargetConfig();
        this.forwardSelectConfig = new ForwardSelectConfig();
        this.forwardCommonConfig = new ForwardCommonConfig();
        this.forwardAdditionNoteConfig = new ForwardAdditionNoteConfig();
        this.forwardConfirmDialogConfig = new ForwardConfirmDialogConfig();
        this.source = Forward$Source.UNKNOWN;
    }

    public final ForwardAdditionNoteConfig getForwardAdditionNoteConfig() {
        return this.forwardAdditionNoteConfig;
    }

    public final ForwardCommonConfig getForwardCommonConfig() {
        return this.forwardCommonConfig;
    }

    public final ForwardConfirmDialogConfig getForwardConfirmDialogConfig() {
        return this.forwardConfirmDialogConfig;
    }

    public final IForwardContent getForwardContent() {
        return this.forwardContent;
    }

    public final ForwardSelectConfig getForwardSelectConfig() {
        return this.forwardSelectConfig;
    }

    public final ForwardTargetConfig getForwardTargetConfig() {
        return this.forwardTargetConfig;
    }

    public final Forward$Source getSource() {
        return this.source;
    }

    public final int getType() {
        return this.type;
    }

    public ForwardTemplateNew(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        this();
        ForwardTargetConfig r0 = (ForwardTargetConfig) r2.readParcelable(ForwardTemplateNew.class.getClassLoader());
        if (r0 != null) goto L5;
        r0 = new ForwardTargetConfig();
    L5:
        this.forwardTargetConfig = r0;
        ForwardSelectConfig r1 = (ForwardSelectConfig) r2.readParcelable(ForwardTemplateNew.class.getClassLoader());
        if (r1 != null) goto L8;
        r1 = new ForwardSelectConfig();
    L8:
        this.forwardSelectConfig = r1;
        ForwardCommonConfig r3 = (ForwardCommonConfig) r2.readParcelable(ForwardTemplateNew.class.getClassLoader());
        if (r3 != null) goto L11;
        r3 = new ForwardCommonConfig();
    L11:
        this.forwardCommonConfig = r3;
        ForwardAdditionNoteConfig r4 = (ForwardAdditionNoteConfig) r2.readParcelable(ForwardTemplateNew.class.getClassLoader());
        if (r4 != null) goto L14;
        r4 = new ForwardAdditionNoteConfig();
    L14:
        this.forwardAdditionNoteConfig = r4;
        ForwardConfirmDialogConfig r5 = (ForwardConfirmDialogConfig) r2.readParcelable(ForwardTemplateNew.class.getClassLoader());
        if (r5 != null) goto L17;
        r5 = new ForwardConfirmDialogConfig();
    L17:
        this.forwardConfirmDialogConfig = r5;
        this.forwardContent = (IForwardContent) r2.readParcelable(ForwardTemplateNew.class.getClassLoader());
        this.type = r2.readInt();
        Forward$Source.a r6 = Forward$Source.Companion;
        int r7 = r2.readInt();
        r6.getClass();
        switch(r7) {
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            default: goto L19;
        };
    L19:
        Forward$Source r8 = Forward$Source.UNKNOWN;
    L23:
        this.source = r8;
        return;
    L20:
        r8 = Forward$Source.DOUBAO;
        goto L23
    L21:
        r8 = Forward$Source.KNOWLEDGE_AI;
        goto L23
    L22:
        r8 = Forward$Source.MY_AI;
        goto L23
    }

    public final void setForwardAdditionNoteConfig(ForwardAdditionNoteConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.forwardAdditionNoteConfig = r2;
    }

    public final void setForwardCommonConfig(ForwardCommonConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.forwardCommonConfig = r2;
    }

    public final void setForwardConfirmDialogConfig(ForwardConfirmDialogConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.forwardConfirmDialogConfig = r2;
    }

    public final void setForwardContent(IForwardContent r1) {
        this.forwardContent = r1;
    }

    public final void setForwardSelectConfig(ForwardSelectConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.forwardSelectConfig = r2;
    }

    public final void setForwardTargetConfig(ForwardTargetConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.forwardTargetConfig = r2;
    }

    public final void setSource(Forward$Source r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.source = r2;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeParcelable(this.forwardTargetConfig, r3);
        r2.writeParcelable(this.forwardSelectConfig, r3);
        r2.writeParcelable(this.forwardCommonConfig, r3);
        r2.writeParcelable(this.forwardAdditionNoteConfig, r3);
        r2.writeParcelable(this.forwardConfirmDialogConfig, r3);
        r2.writeParcelable(this.forwardContent, r3);
        r2.writeInt(this.type);
        r2.writeInt(this.source.getValue());
    }
}
