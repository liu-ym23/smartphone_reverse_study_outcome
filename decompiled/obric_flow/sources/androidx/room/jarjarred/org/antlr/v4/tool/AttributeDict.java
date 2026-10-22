package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class AttributeDict {
    public static final AttributeDict predefinedTokenDict = null;
    public GrammarAST ast;
    public final LinkedHashMap<String, Attribute> attributes;
    public String name;
    public DictType type;

    public static final enum DictType extends Enum<DictType> {
        private static final /* synthetic */ DictType[] $VALUES = null;
        public static final DictType ARG = null;
        public static final DictType LOCAL = null;
        public static final DictType PREDEFINED_LEXER_RULE = null;
        public static final DictType PREDEFINED_RULE = null;
        public static final DictType RET = null;
        public static final DictType TOKEN = null;

        static {
            DictType r5 = new DictType("ARG", 0);
            ARG = r5;
            DictType r10 = new DictType("RET", 1);
            RET = r10;
            DictType r11 = new DictType("LOCAL", 2);
            LOCAL = r11;
            DictType r12 = new DictType("TOKEN", 3);
            TOKEN = r12;
            DictType r13 = new DictType("PREDEFINED_RULE", 4);
            PREDEFINED_RULE = r13;
            DictType r14 = new DictType("PREDEFINED_LEXER_RULE", 5);
            PREDEFINED_LEXER_RULE = r14;
            $VALUES = new DictType[]{r5, r10, r11, r12, r13, r14};
        }

        private DictType(String r5, int r10) {
            super(r5, r10);
        }

        public static DictType valueOf(String r5) {
            return (DictType) Enum.valueOf(DictType.class, r5);
        }

        public static DictType[] values() {
            return (DictType[]) $VALUES.clone();
        }
    }

    static {
        AttributeDict r5 = new AttributeDict(DictType.TOKEN);
        predefinedTokenDict = r5;
        r5.add(new Attribute(MessageIndication.CONTENT_TYPE_TEXT));
        r5.add(new Attribute("type"));
        r5.add(new Attribute(SVGRenderEngine.LINE));
        r5.add(new Attribute("index"));
        r5.add(new Attribute(OpenPageMethod.KEY_POS));
        r5.add(new Attribute(LynxMonitorService.KEY_CHANNEL));
        r5.add(new Attribute("int"));
    }

    public AttributeDict() {
        this.attributes = new LinkedHashMap();
    }

    public Attribute add(Attribute r5) {
        r5.dict = this;
        return this.attributes.put(r5.name, r5);
    }

    public Attribute get(String r5) {
        return this.attributes.get(r5);
    }

    public String getName() {
        return this.name;
    }

    public Set<String> intersection(AttributeDict r5) {
        if (r5 == null) goto L11;
        if (r5.size() == 0) goto L11;
        if (size() == 0) goto L11;
        HashSet r10 = new HashSet(this.attributes.keySet());
        r10.retainAll(r5.attributes.keySet());
        return r10;
    L11:
        return Collections.emptySet();
    }

    public int size() {
        return this.attributes.size();
    }

    public String toString() {
        return getName() + ":" + this.attributes;
    }

    public AttributeDict(DictType r5) {
        this.attributes = new LinkedHashMap();
        this.type = r5;
    }
}
