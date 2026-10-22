package com.obric.oui.constraintlayout.core.state;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class ConstraintReference {

    static class IncorrectConstraintException extends Exception {
        private final ArrayList<String> mErrors;

        IncorrectConstraintException(ArrayList<String> r1) {
            this.mErrors = r1;
        }

        public ArrayList<String> getErrors() {
            return this.mErrors;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return toString();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "IncorrectConstraintException: " + this.mErrors.toString();
        }
    }
}
