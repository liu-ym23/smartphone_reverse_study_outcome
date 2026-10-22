package com.larus.bmhome.instruction.handler;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/instruction/handler/InstructionHandlerType;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface InstructionHandlerType {
    public static final String AVATAR = "AVATAR";
    public static final a Companion = null;
    public static final String IMAGE_TO_IMAGE = "IMAGE_TO_IMAGE";
    public static final String MUSIC = "MUSIC";
    public static final String SCHEMA_INTERCEPT = "SCHEMA_INTERCEPT";
    public static final String TEXT_TO_IMAGE = "TEXT_TO_IMAGE";
    public static final String TEXT_TO_OPEN_CAMERA = "TEXT_TO_OPEN_CAMERA";
    public static final String TEXT_TO_TEXT = "TEXT_TO_TEXT";
    public static final String UNKNOWN = "";
    public static final String VIDEO = "VIDEO";

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
}
