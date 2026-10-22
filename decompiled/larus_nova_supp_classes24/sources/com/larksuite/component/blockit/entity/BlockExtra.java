package com.larksuite.component.blockit.entity;

import com.larksuite.component.blockit.entity.richtext.RichTextMessage;
import com.larksuite.component.blockit.entity.todo.MultiMessage;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class BlockExtra implements Serializable {
    public String contextJson;
    public Map<String, Object> hitPointParams;
    public MultiMessage multiMessage;
    public String parentMsgSenderId;
    public RichTextMessage richTextMessage;
    public SceneType sceneType;

    public static final enum SceneType extends Enum<SceneType> {
        public static final SceneType CHAT_MULTI = null;
        public static final SceneType INPUT_BOX = null;
        public static final SceneType MESSAGE_TOOLBAR = null;
        public static final SceneType THREAD_MULTI = null;
        public static final SceneType THREAD_REPLY = null;
        public static final SceneType THREAD_TOPIC = null;
        public static final /* synthetic */ SceneType[] a = null;
        private final int value;

        static {
            SceneType r0 = new SceneType("THREAD_TOPIC", 0, 1);
            THREAD_TOPIC = r0;
            SceneType r1 = new SceneType("THREAD_REPLY", 1, 2);
            THREAD_REPLY = r1;
            SceneType r4 = new SceneType("THREAD_MULTI", 2, 3);
            THREAD_MULTI = r4;
            SceneType r6 = new SceneType("MESSAGE_TOOLBAR", 3, 4);
            MESSAGE_TOOLBAR = r6;
            SceneType r8 = new SceneType("INPUT_BOX", 4, 5);
            INPUT_BOX = r8;
            SceneType r10 = new SceneType("CHAT_MULTI", 5, 6);
            CHAT_MULTI = r10;
            a = new SceneType[]{r0, r1, r4, r6, r8, r10};
        }

        public static SceneType[] values() {
            return (SceneType[]) a.clone();
        }

        public static SceneType valueOf(String r1) {
            return (SceneType) r27.a.a(SceneType.class, r1);
        }

        public SceneType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public BlockExtra() {
    }

    public Map<String, Object> getHitPointParams() {
        Map<String, Object> r0 = this.hitPointParams;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new HashMap();
    }
}
