package com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime;

import java.io.Serializable;
import java.util.SimpleTimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class TimeZone implements Serializable {
    public static final java.util.TimeZone MISSING = null;
    public static final java.util.TimeZone ZERO = null;
    private static final long serialVersionUID = 1;
    public int minutes;

    private static class JavaMissingTimeZone extends SimpleTimeZone implements Serializable {
        private static final long serialVersionUID = 1;

        JavaMissingTimeZone() {
            super(0, "XSD missing timezone");
        }

        public Object readResolve() {
            return TimeZone.MISSING;
        }
    }

    private static class JavaZeroTimeZone extends SimpleTimeZone implements Serializable {
        private static final long serialVersionUID = 1;

        JavaZeroTimeZone() {
            super(0, "XSD 'Z' timezone");
        }

        public Object readResolve() {
            return TimeZone.ZERO;
        }
    }

    static class ZeroTimeZone extends TimeZone {
        private static final long serialVersionUID = 1;

        ZeroTimeZone() {
        }

        public Object readResolve() {
            return ZERO;
        }
    }

    static {
        ZERO = new JavaZeroTimeZone();
        MISSING = new JavaMissingTimeZone();
    }

    public TimeZone() {
    }

    private Object readResolve() {
        return new SimpleTimeZone((this.minutes * 60) * 1000, "");
    }
}
