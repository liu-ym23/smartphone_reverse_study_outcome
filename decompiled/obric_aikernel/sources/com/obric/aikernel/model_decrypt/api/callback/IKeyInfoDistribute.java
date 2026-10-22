package com.obric.aikernel.model_decrypt.api.callback;

import java.util.Set;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface IKeyInfoDistribute {

    public static final class KeyInfoItem {
        private final String fileName;
        private final String keyInfo;
        private final String modelName;

        public KeyInfoItem(String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "modelName");
            Intrinsics.checkNotNullParameter(r11, "fileName");
            Intrinsics.checkNotNullParameter(r12, "keyInfo");
            this.modelName = r10;
            this.fileName = r11;
            this.keyInfo = r12;
        }

        public static /* synthetic */ KeyInfoItem copy$default(KeyInfoItem r10, String r11, String r12, String r13, int r14, Object r15) {
            if ((r14 & 1) == 0) goto L6;
            r11 = r10.modelName;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r12 = r10.fileName;
        L9:
            if ((r14 & 4) == 0) goto L12;
            r13 = r10.keyInfo;
        L12:
            return r10.copy(r11, r12, r13);
        }

        public final String component1() {
            return this.modelName;
        }

        public final String component2() {
            return this.fileName;
        }

        public final String component3() {
            return this.keyInfo;
        }

        public final KeyInfoItem copy(String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "modelName");
            Intrinsics.checkNotNullParameter(r11, "fileName");
            Intrinsics.checkNotNullParameter(r12, "keyInfo");
            return new KeyInfoItem(r10, r11, r12);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof KeyInfoItem) == true) goto L8;
            return false;
        L8:
            KeyInfoItem r11 = (KeyInfoItem) r10;
            if (Intrinsics.areEqual(this.modelName, r11.modelName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.fileName, r11.fileName) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.keyInfo, r11.keyInfo) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final String getKeyInfo() {
            return this.keyInfo;
        }

        public final String getModelName() {
            return this.modelName;
        }

        public int hashCode() {
            return (((this.modelName.hashCode() * 31) + this.fileName.hashCode()) * 31) + this.keyInfo.hashCode();
        }

        public String toString() {
            return "KeyInfoItem(modelName=" + this.modelName + ", fileName=" + this.fileName + ", keyInfo=" + this.keyInfo + ')';
        }
    }

    /* JADX INFO: renamed from: onRequestKeyInfo-BWLJW6A */
    Object mo17onRequestKeyInfoBWLJW6A(String r10, String r11, Set<String> r12, Continuation<? super Result<? extends Set<KeyInfoItem>>> r13);
}
