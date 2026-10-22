package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00102\u00020\u0001:\u0007\n\u000b\f\r\u000e\u000f\u0010R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0006\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction;", "Landroid/os/Parcelable;", "rawValue", NameKeys.UnloadStrategy_No_Strategy, "getRawValue", "()Ljava/lang/String;", "allowsSkillUse", NameKeys.UnloadStrategy_No_Strategy, "getAllowsSkillUse", "()Z", "Allow", "Notice", "CallUser", "Clarify", "Block", "Unknown", "Companion", "Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction$Allow;", "Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction$Block;", "Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction$CallUser;", "Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction$Clarify;", "Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction$Notice;", "Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction$Unknown;", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SkillSecurityDecisionAction extends Parcelable {
    public static final a Companion = null;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\rHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction$Allow;", "Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction;", "<init>", "()V", "rawValue", NameKeys.UnloadStrategy_No_Strategy, "getRawValue", "()Ljava/lang/String;", "allowsSkillUse", NameKeys.UnloadStrategy_No_Strategy, "getAllowsSkillUse", "()Z", "describeContents", NameKeys.UnloadStrategy_No_Strategy, "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Allow implements SkillSecurityDecisionAction {
        public static final Parcelable.Creator<Allow> CREATOR = null;
        public static final Allow INSTANCE = null;
        private static final boolean allowsSkillUse = false;
        private static final String rawValue = null;

        public static final class a implements Parcelable.Creator<Allow> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Allow createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "parcel");
                r2.readInt();
                return Allow.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final Allow[] newArray(int r1) {
                return new Allow[r1];
            }
        }

        private Allow() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof Allow) == true) goto L9;
            return false;
        L9:
            Allow r4 = (Allow) r3;
            return true;
        }

        public int hashCode() {
            return 476038720;
        }

        public String toString() {
            return "Allow";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeInt(1);
        }

        static {
            INSTANCE = new Allow();
            rawValue = "allow";
            allowsSkillUse = true;
            CREATOR = new a();
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public boolean getAllowsSkillUse() {
            return allowsSkillUse;
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public String getRawValue() {
            return rawValue;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\rHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction$Block;", "Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction;", "<init>", "()V", "rawValue", NameKeys.UnloadStrategy_No_Strategy, "getRawValue", "()Ljava/lang/String;", "allowsSkillUse", NameKeys.UnloadStrategy_No_Strategy, "getAllowsSkillUse", "()Z", "describeContents", NameKeys.UnloadStrategy_No_Strategy, "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Block implements SkillSecurityDecisionAction {
        public static final Parcelable.Creator<Block> CREATOR = null;
        public static final Block INSTANCE = null;
        private static final boolean allowsSkillUse = false;
        private static final String rawValue = null;

        public static final class a implements Parcelable.Creator<Block> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Block createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "parcel");
                r2.readInt();
                return Block.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final Block[] newArray(int r1) {
                return new Block[r1];
            }
        }

        private Block() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof Block) == true) goto L9;
            return false;
        L9:
            Block r4 = (Block) r3;
            return true;
        }

        public int hashCode() {
            return 476964740;
        }

        public String toString() {
            return "Block";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeInt(1);
        }

        static {
            INSTANCE = new Block();
            rawValue = "block";
            CREATOR = new a();
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public boolean getAllowsSkillUse() {
            return allowsSkillUse;
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public String getRawValue() {
            return rawValue;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\rHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction$CallUser;", "Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction;", "<init>", "()V", "rawValue", NameKeys.UnloadStrategy_No_Strategy, "getRawValue", "()Ljava/lang/String;", "allowsSkillUse", NameKeys.UnloadStrategy_No_Strategy, "getAllowsSkillUse", "()Z", "describeContents", NameKeys.UnloadStrategy_No_Strategy, "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CallUser implements SkillSecurityDecisionAction {
        public static final Parcelable.Creator<CallUser> CREATOR = null;
        public static final CallUser INSTANCE = null;
        private static final boolean allowsSkillUse = false;
        private static final String rawValue = null;

        public static final class a implements Parcelable.Creator<CallUser> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final CallUser createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "parcel");
                r2.readInt();
                return CallUser.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final CallUser[] newArray(int r1) {
                return new CallUser[r1];
            }
        }

        private CallUser() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof CallUser) == true) goto L9;
            return false;
        L9:
            CallUser r4 = (CallUser) r3;
            return true;
        }

        public int hashCode() {
            return 1996841202;
        }

        public String toString() {
            return "CallUser";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeInt(1);
        }

        static {
            INSTANCE = new CallUser();
            rawValue = "call_user";
            allowsSkillUse = true;
            CREATOR = new a();
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public boolean getAllowsSkillUse() {
            return allowsSkillUse;
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public String getRawValue() {
            return rawValue;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\rHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction$Clarify;", "Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction;", "<init>", "()V", "rawValue", NameKeys.UnloadStrategy_No_Strategy, "getRawValue", "()Ljava/lang/String;", "allowsSkillUse", NameKeys.UnloadStrategy_No_Strategy, "getAllowsSkillUse", "()Z", "describeContents", NameKeys.UnloadStrategy_No_Strategy, "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Clarify implements SkillSecurityDecisionAction {
        public static final Parcelable.Creator<Clarify> CREATOR = null;
        public static final Clarify INSTANCE = null;
        private static final boolean allowsSkillUse = false;
        private static final String rawValue = null;

        public static final class a implements Parcelable.Creator<Clarify> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Clarify createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "parcel");
                r2.readInt();
                return Clarify.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final Clarify[] newArray(int r1) {
                return new Clarify[r1];
            }
        }

        private Clarify() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof Clarify) == true) goto L9;
            return false;
        L9:
            Clarify r4 = (Clarify) r3;
            return true;
        }

        public int hashCode() {
            return -323362919;
        }

        public String toString() {
            return "Clarify";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeInt(1);
        }

        static {
            INSTANCE = new Clarify();
            rawValue = "clarify";
            allowsSkillUse = true;
            CREATOR = new a();
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public boolean getAllowsSkillUse() {
            return allowsSkillUse;
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public String getRawValue() {
            return rawValue;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\rHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction$Notice;", "Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction;", "<init>", "()V", "rawValue", NameKeys.UnloadStrategy_No_Strategy, "getRawValue", "()Ljava/lang/String;", "allowsSkillUse", NameKeys.UnloadStrategy_No_Strategy, "getAllowsSkillUse", "()Z", "describeContents", NameKeys.UnloadStrategy_No_Strategy, "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Notice implements SkillSecurityDecisionAction {
        public static final Parcelable.Creator<Notice> CREATOR = null;
        public static final Notice INSTANCE = null;
        private static final boolean allowsSkillUse = false;
        private static final String rawValue = null;

        public static final class a implements Parcelable.Creator<Notice> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Notice createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "parcel");
                r2.readInt();
                return Notice.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public final Notice[] newArray(int r1) {
                return new Notice[r1];
            }
        }

        private Notice() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof Notice) == true) goto L9;
            return false;
        L9:
            Notice r4 = (Notice) r3;
            return true;
        }

        public int hashCode() {
            return -2047487295;
        }

        public String toString() {
            return "Notice";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeInt(1);
        }

        static {
            INSTANCE = new Notice();
            rawValue = "notice";
            allowsSkillUse = true;
            CREATOR = new a();
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public boolean getAllowsSkillUse() {
            return allowsSkillUse;
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public String getRawValue() {
            return rawValue;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction$Unknown;", "Lcom/obric/aiagent/assistant/idl/bean/SkillSecurityDecisionAction;", "rawValue", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "allowsSkillUse", NameKeys.UnloadStrategy_No_Strategy, "getAllowsSkillUse", "()Z", "component1", "copy", "describeContents", NameKeys.UnloadStrategy_No_Strategy, "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Unknown implements SkillSecurityDecisionAction {
        public static final Parcelable.Creator<Unknown> CREATOR = null;
        private final boolean allowsSkillUse;
        private final String rawValue;

        public static final class a implements Parcelable.Creator<Unknown> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Unknown createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "parcel");
                return new Unknown(r2.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final Unknown[] newArray(int r1) {
                return new Unknown[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public static /* synthetic */ Unknown copy$default(Unknown r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.rawValue;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.rawValue;
        }

        public final Unknown copy(String r2) {
            Intrinsics.checkNotNullParameter(r2, "rawValue");
            return new Unknown(r2);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Unknown) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.rawValue, ((Unknown) r4).rawValue) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.rawValue.hashCode();
        }

        public String toString() {
            return "Unknown(rawValue=" + this.rawValue + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeString(this.rawValue);
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public boolean getAllowsSkillUse() {
            return this.allowsSkillUse;
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public String getRawValue() {
            return this.rawValue;
        }

        public Unknown(String r2) {
            Intrinsics.checkNotNullParameter(r2, "rawValue");
            this.rawValue = r2;
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }

    boolean getAllowsSkillUse();

    String getRawValue();
}
