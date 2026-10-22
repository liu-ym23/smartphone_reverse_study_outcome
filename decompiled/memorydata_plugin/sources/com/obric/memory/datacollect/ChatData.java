package com.obric.memory.datacollect;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ChatData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String audioToText;
    public String chatName;
    public int chatPeopleNum;
    public int chatType;
    public String msgContent;
    public String msgPerson;
    public int msgType;
    public String refPerson;
    public String refSource;
    public int timeAccuracy;
    public long timestamp;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ChatData() {
    }
}
